package chattyer.nlp.wit.client.entities;

import org.immutables.value.Value;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;

@Value.Immutable
public abstract class ListEntitiesRequest extends AbstractApplicationScopedWitRequest {

    @Override
    public Request get(WitContext witContext) {
        return getRequestBuilder(witContext).get()
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("entities")
                             .build();
    }

}
