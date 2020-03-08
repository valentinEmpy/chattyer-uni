package chattyer.nlp.wit.client.apps;

import com.fasterxml.jackson.annotation.JsonCreator;

import chattyer.nlp.wit.models.ApplicationCredentials;
import chattyer.nlp.wit.models.Response;

public class PostApplicationResponse extends Response<ApplicationCredentials> {

    @JsonCreator
    public PostApplicationResponse(ApplicationCredentials applicationCredentials) {
        super(applicationCredentials);
    }

}
