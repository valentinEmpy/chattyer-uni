package chattyer.web.security;

import java.util.Collection;
import java.util.Collections;

import org.immutables.value.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Value.Immutable
public interface UserDetailsImpl extends UserDetails {

    String getUsername();

    @JsonIgnore
    @Value.Auxiliary
    String getPassword();

    @Value.Default
    @Override
    default boolean isAccountNonExpired() {
        return true;
    }

    @Value.Default
    @Override
    default boolean isAccountNonLocked() {
        return true;
    }

    @Value.Default
    @Override
    default boolean isCredentialsNonExpired() {
        return true;
    }

    @Value.Default
    @Override
    default boolean isEnabled() {
        return true;
    }

    @Value.Default
    @Override
    default Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

}
