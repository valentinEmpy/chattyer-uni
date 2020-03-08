package chattyer.nlp.wit.client.apps;

import chattyer.nlp.wit.models.Application;
import chattyer.nlp.wit.models.Response;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class GetApplicationResponse extends Response<Application> {

    @JsonCreator
    public GetApplicationResponse(@JsonUnwrapped Application application) {
        super(application);
    }

}
