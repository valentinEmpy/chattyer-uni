package chattyer.web.api;

import chattyer.web.api.models.AuthRequestBody;
import chattyer.web.api.models.Token;
import org.springframework.http.ResponseEntity;

import chattyer.persistence.models.User;

public interface AuthApiService {

    ResponseEntity<Token> authenticateUser(AuthRequestBody authRequestBody);

    ResponseEntity<User> registerUser(AuthRequestBody authRequestBody);

}
