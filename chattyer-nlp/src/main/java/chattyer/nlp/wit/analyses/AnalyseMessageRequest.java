package chattyer.nlp.wit.analyses;

import org.immutables.value.Value;

import com.sun.istack.Nullable;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;

@Value.Immutable
public abstract class AnalyseMessageRequest extends AbstractApplicationScopedWitRequest {

    public abstract String getMessage();

    @Nullable
    public abstract String getThreadId();

    @Value.Default
    public int getMaxEntitiesResult() {
        return 8;
    }

    @Value.Check
    protected void isValid() {
        int messageLength = getMessage().length();
        if (messageLength <= 0 || messageLength > 280) {
            throw new IllegalArgumentException("The message (text) associated with an analysis request must be greater than 0 and less than 280 characters long");
        }
        if (getMaxEntitiesResult() <= 0 || getMaxEntitiesResult() > 8) {
            throw new IllegalArgumentException("The max entities to be retrieved via an analysis request must be greater than 0 and less than or equal to 8");
        }
    }

    @Override
    public Request get(WitContext witContext) {
        return getRequestBuilder(witContext).get()
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        httpUrlBuilder.addPathSegment("message")
                      .addQueryParameter("q", getMessage())
                      .addQueryParameter("n", Integer.toString(getMaxEntitiesResult()));
        if (getThreadId() != null) {
            httpUrlBuilder.addQueryParameter("thread_id", getThreadId());
        }
        return httpUrlBuilder.build();
    }

}
