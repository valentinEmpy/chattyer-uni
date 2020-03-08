package chattyer.nlp.wit.client.entities;

import org.immutables.value.Value;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;

@Value.Immutable
public abstract class DeleteEntityValueExpressionRequest extends AbstractApplicationScopedWitRequest {

    public abstract String getEntityId();

    public abstract String getEntityValue();

    public abstract String getExpression();

    @Override
    public Request get(WitContext witContext) {
        return getRequestBuilder(witContext).delete()
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("entities")
                             .addPathSegment(getEntityId())
                             .addPathSegment("values")
                             .addPathSegment(getEntityValue())
                             .addPathSegment("expressions")
                             .addPathSegment(getExpression())
                             .build();
    }

}
