package chattyer.nlp.wit.client.apps;

import chattyer.nlp.wit.client.PaginatedWitRequest;
import org.immutables.value.Value;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;

@Value.Immutable
public abstract class ListApplicationsWitRequest extends AbstractWitRequest implements PaginatedWitRequest {

    private static final long LIMIT = 10000;

    @Value.Default
    protected long getOffset() {
        return 0;
    }

    @Override
    public Request get(WitContext witContext) {
        return getRequestBuilder(witContext).get()
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("apps")
                             .addQueryParameter("limit", Long.toString(LIMIT))
                             .addQueryParameter("offset", Long.toString(getOffset()))
                             .build();
    }

    @Override
    public PaginatedWitRequest getForNextPage(WitContext witContext) {
        return ImmutableListApplicationsWitRequest.builder()
                                                  .from(this)
                                                  .offset(getOffset() + LIMIT)
                                                  .build();
    }

}
