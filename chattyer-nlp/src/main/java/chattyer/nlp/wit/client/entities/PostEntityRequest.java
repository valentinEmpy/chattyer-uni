package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.models.MediaTypes;
import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

@Value.Immutable
@JsonSerialize(as = ImmutablePostEntityRequest.class)
public abstract class PostEntityRequest extends AbstractApplicationScopedWitRequest {

    public abstract String getId();

    @Nullable
    public abstract String getDoc();

    @Override
    public Request get(WitContext witContext) {
        String jsonBody = toJson(this, witContext);
        return getRequestBuilder(witContext).post(RequestBody.create(MediaTypes.JSON, jsonBody))
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("entities")
                             .build();
    }

}
