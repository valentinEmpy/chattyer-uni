package chattyer.nlp.wit.client;

import com.fasterxml.jackson.annotation.JsonIgnore;

import chattyer.nlp.wit.TokenProvider;

public abstract class AbstractApplicationScopedWitRequest extends AbstractWitRequest {

    @JsonIgnore
    public abstract String getApplicationId();

    @Override
    protected String getToken(TokenProvider tokenProvider) {
        return tokenProvider.getToken(getApplicationId());
    }

}
