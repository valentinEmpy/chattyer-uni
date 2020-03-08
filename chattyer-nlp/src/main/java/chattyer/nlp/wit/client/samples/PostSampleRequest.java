package chattyer.nlp.wit.client.samples;

import java.util.List;

import org.immutables.value.Value;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import chattyer.nlp.wit.models.MediaTypes;
import chattyer.nlp.wit.models.Sample;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

@Value.Immutable
public abstract class PostSampleRequest extends AbstractApplicationScopedWitRequest {

    public abstract List<Sample> getSamples();

    @Override
    public Request get(WitContext witContext) {
        String jsonBody = toJson(getSamples(), witContext);
        return getRequestBuilder(witContext).post(RequestBody.create(MediaTypes.JSON, jsonBody))
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("samples")
                             .build();
    }

}
