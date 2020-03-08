package chattyer.nlp.wit.client.apps;

import chattyer.common.models.Language;
import chattyer.nlp.wit.models.MediaTypes;
import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

@Value.Immutable
@JsonSerialize(as = ImmutablePostApplicationRequest.class)
public abstract class PostApplicationRequest extends AbstractWitRequest {

    public abstract String getName();

    public abstract Language getLang();

    @JsonProperty("private")
    public abstract boolean getIsPrivate();

    @Nullable
    public abstract String getDesc();

    @Override
    public Request get(WitContext witContext) {
        String jsonBody = toJson(this, witContext);
        return getRequestBuilder(witContext).post(RequestBody.create(MediaTypes.JSON, jsonBody))
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("apps")
                             .build();
    }

}
