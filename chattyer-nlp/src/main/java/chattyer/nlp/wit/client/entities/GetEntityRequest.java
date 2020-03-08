package chattyer.nlp.wit.client.entities;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;

@Value.Immutable
@JsonSerialize(as = ImmutableGetEntityRequest.class)
public abstract class GetEntityRequest extends AbstractApplicationScopedWitRequest {

    public abstract String getEntityId();

    @Override
    public Request get(WitContext witContext) {
        return getRequestBuilder(witContext).get()
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("entities")
                             .addPathSegment(getEntityId())
                             .build();
    }

}
