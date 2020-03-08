package chattyer.nlp.wit;

import java.util.Optional;

import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import okhttp3.OkHttpClient;

@Value.Immutable
public interface WitContext {

    OkHttpClient getHttpClient();

    @Value.Default
    default ObjectMapper getObjectMapper() {
        return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
                                 .registerModule(new Jdk8Module());
    }

    TokenProvider getTokenProvider();

    @Value.Default
    default String getRootWitUrl() {
        return "https://api.wit.ai";
    }

    Optional<String> getWitApiVersion();

}
