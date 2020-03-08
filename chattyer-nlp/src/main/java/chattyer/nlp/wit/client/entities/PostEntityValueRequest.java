package chattyer.nlp.wit.client.entities;

import java.util.List;

import chattyer.nlp.wit.models.MediaTypes;
import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

@Value.Immutable
@JsonSerialize(as = PostEntityValueRequest.class)
public abstract class PostEntityValueRequest extends AbstractApplicationScopedWitRequest {

    @JsonIgnore
    public abstract String getEntityId();

    @JsonProperty("value")
    public abstract String getEntityValue();

    public abstract List<String> getExpressions();

    @Nullable
    public abstract String getMetadata();

    @Override
    public Request get(WitContext witContext) {
        String jsonBody = toJson(this, witContext);
        return getRequestBuilder(witContext).post(RequestBody.create(MediaTypes.JSON, jsonBody))
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("entities")
                             .addPathSegment(getEntityId())
                             .addPathSegment("values")
                             .build();
    }

}
