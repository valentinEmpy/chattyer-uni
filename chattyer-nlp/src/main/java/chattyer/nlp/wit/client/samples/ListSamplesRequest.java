package chattyer.nlp.wit.client.samples;

import java.util.List;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import chattyer.nlp.wit.client.PaginatedWitRequest;
import org.immutables.value.Value;

import okhttp3.HttpUrl;
import okhttp3.Request;

@Value.Immutable
public abstract class ListSamplesRequest extends AbstractApplicationScopedWitRequest implements PaginatedWitRequest {

    private static final long LIMIT = 10000;

    @Value.Default
    protected long getOffset() {
        return 0;
    }

    public abstract List<String> getEntityIds();

    public abstract List<String> getEntityValues();

    @Override
    public Request get(WitContext witContext) {
        return getRequestBuilder(witContext).get()
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        httpUrlBuilder.addPathSegment("samples")
                      .addQueryParameter("limit", Long.toString(LIMIT))
                      .addQueryParameter("offset", Long.toString(getOffset()));
        if (!getEntityIds().isEmpty()) {
            httpUrlBuilder.addQueryParameter("entity_ids", String.join(",", getEntityIds()));
        }
        if (!getEntityValues().isEmpty()) {
            httpUrlBuilder.addQueryParameter("entity_values", String.join(",", getEntityValues()));
        }
        return httpUrlBuilder.build();
    }

    @Override
    public PaginatedWitRequest getForNextPage(WitContext witContext) {
        return ImmutableListSamplesRequest.builder()
                                          .from(this)
                                          .offset(getOffset() + LIMIT)
                                          .build();
    }

}
