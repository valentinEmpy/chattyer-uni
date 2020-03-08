package chattyer.web.api.impl;

import javax.transaction.Transactional;

import chattyer.web.api.models.AuthRequestBody;
import chattyer.web.api.models.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import chattyer.persistence.models.User;
import chattyer.persistence.repositories.UserRepository;
import chattyer.web.api.AuthApiService;
import chattyer.web.api.models.ImmutableToken;
import chattyer.web.exceptions.UsernameTakenException;
import chattyer.web.messages.Messages;
import chattyer.web.security.JwtUtils;

@Component
public class AuthApiServiceImpl implements AuthApiService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtils jwtUtils;

    @Autowired
    public AuthApiServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder,
                              JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    @Transactional
    public ResponseEntity<Token> authenticateUser(AuthRequestBody authRequestBody) {
        Authentication authentication = authenticationManager.authenticate(toAuthenticationToken(authRequestBody));
        SecurityContextHolder.getContext()
                             .setAuthentication(authentication);
        String jwt = jwtUtils.generateJwt(authentication);
        Token token = ImmutableToken.builder()
                                    .accessToken(jwt)
                                    .build();
        return ResponseEntity.ok(token);
    }

    private UsernamePasswordAuthenticationToken toAuthenticationToken(AuthRequestBody authRequestBody) {
        return new UsernamePasswordAuthenticationToken(authRequestBody.getUsername(), authRequestBody.getPassword());
    }

    @Override
    @Transactional
    public ResponseEntity<User> registerUser(AuthRequestBody authRequestBody) {
        if (userRepository.existsByUsernameIgnoreCase(authRequestBody.getUsername())) {
            throw new UsernameTakenException(Messages.USERNAME_0_IS_ALREADY_TAKEN, authRequestBody.getUsername());
        }
        User user = toUser(authRequestBody);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    private User toUser(AuthRequestBody signUpRequestBody) {
        String encodedPassword = passwordEncoder.encode(signUpRequestBody.getPassword());
        return User.builder()
                   .username(signUpRequestBody.getUsername())
                   .password(encodedPassword)
                   .build();
    }

}
