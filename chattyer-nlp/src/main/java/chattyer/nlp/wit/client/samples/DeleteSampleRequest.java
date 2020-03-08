package chattyer.nlp.wit.client.samples;

import java.util.List;
import java.util.stream.Collectors;

import org.immutables.value.Value;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import chattyer.nlp.wit.models.MediaTypes;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

@Value.Immutable
public abstract class DeleteSampleRequest extends AbstractApplicationScopedWitRequest {

    public abstract List<String> getTexts();

    @Override
    public Request get(WitContext witContext) {
        List<SampleToDelete> samplesToDelete = getTexts().stream()
                                                         .map(text -> ImmutableSampleToDelete.builder()
                                                                                                                                .text(text)
                                                                                                                                .build())
                                                         .collect(Collectors.toList());
        String jsonBody = toJson(samplesToDelete, witContext);
        return getRequestBuilder(witContext).delete(RequestBody.create(MediaTypes.JSON, jsonBody))
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("samples")
                             .build();
    }

    @Value.Immutable
    interface SampleToDelete {

        String getText();

    }

}
