package chattyer.nlp.wit.client.entities;

import java.util.List;

import chattyer.nlp.wit.models.ExtendedEntity;
import chattyer.nlp.wit.models.MediaTypes;
import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.Nullable;

import chattyer.nlp.wit.WitContext;
import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

@Value.Immutable
@JsonSerialize(as = UpdateEntityRequest.class)
public abstract class UpdateEntityRequest extends AbstractApplicationScopedWitRequest {

    @JsonIgnore
    public abstract String getId();

    @Nullable
    @JsonProperty("id")
    public abstract String getNewId();

    @Nullable
    @JsonProperty("doc")
    public abstract String getNewDoc();

    @Nullable
    @JsonProperty("values")
    public abstract List<ExtendedEntity.Value> getNewValues();

    @Override
    public Request get(WitContext witContext) {
        String jsonBody = toJson(this, witContext);
        return getRequestBuilder(witContext).put(RequestBody.create(MediaTypes.JSON, jsonBody))
                                            .build();
    }

    @Override
    protected HttpUrl buildHttpUrl(HttpUrl.Builder httpUrlBuilder) {
        return httpUrlBuilder.addPathSegment("entities")
                             .addPathSegment(getId())
                             .build();
    }

}
