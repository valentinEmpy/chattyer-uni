package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.models.MediaTypes;
import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

@Value.Immutable
@JsonSerialize(as = PostEntityValueExpressionRequest.class)
public abstract class PostEntityValueExpressionRequest extends AbstractApplicationScopedWitRequest {

    @JsonIgnore
    public abstract String getEntityId();

    @JsonIgnore
    public abstract String getEntityValue();

    public abstract String getExpression();

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
                             .addPathSegment(getEntityValue())
                             .addPathSegment("expressions")
                             .build();
    }

}
