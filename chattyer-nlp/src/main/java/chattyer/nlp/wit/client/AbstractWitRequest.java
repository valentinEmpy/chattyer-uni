package chattyer.nlp.wit.client;

import java.io.UncheckedIOException;
import java.text.MessageFormat;

import com.fasterxml.jackson.core.JsonProcessingException;

import chattyer.nlp.wit.TokenProvider;
import chattyer.nlp.wit.WitContext;
import okhttp3.HttpUrl;
import okhttp3.Request;

public abstract class AbstractWitRequest implements WitRequest {

    protected String toJson(Object object, WitContext witContext) {
        try {
            return witContext.getObjectMapper()
                             .writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException("Failed building json body for wit request", e);
        }
    }

    protected Request.Builder getRequestBuilder(WitContext witContext) {
        HttpUrl.Builder httpUrlBuilder = HttpUrl.get(witContext.getRootWitUrl())
                                                .newBuilder();
        witContext.getWitApiVersion()
                  .ifPresent(apiVersion -> httpUrlBuilder.addQueryParameter("v", apiVersion));
        HttpUrl url = buildHttpUrl(httpUrlBuilder);
        String authorizationHeaderValue = getAuthorizationHeaderValue(witContext.getTokenProvider());
        return new Request.Builder().url(url)
                                    .addHeader("Authorization", authorizationHeaderValue);
    }

    protected abstract HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder);

    protected String getAuthorizationHeaderValue(TokenProvider tokenProvider) {
        return MessageFormat.format("Bearer {0}", getToken(tokenProvider));
    }

    protected String getToken(TokenProvider tokenProvider) {
        return tokenProvider.getToken(null);
    }

}
