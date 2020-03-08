package chattyer.nlp.wit.client.apps;

import java.util.List;

import chattyer.nlp.wit.models.Application;
import chattyer.nlp.wit.models.ListResponse;
import com.fasterxml.jackson.annotation.JsonCreator;

public class ListApplicationsResponse extends ListResponse<Application> {

    @JsonCreator
    public ListApplicationsResponse(List<Application> applications) {
        super(applications);
    }

}
