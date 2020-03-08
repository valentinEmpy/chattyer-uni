package chattyer.nlp.wit.client.apps;

import org.immutables.value.Value;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;

@Value.Immutable
public abstract class DeleteApplicationRequest extends AbstractApplicationScopedWitRequest {

    @Override
    public Request get(WitContext witContext) {
        return getRequestBuilder(witContext).delete()
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("apps")
                             .addPathSegment(getApplicationId())
                             .build();
    }

}
