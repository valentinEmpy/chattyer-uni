package chattyer.nlp.wit.client.samples;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

import chattyer.nlp.wit.models.ListResponse;
import chattyer.nlp.wit.models.Sample;

public class ListSamplesResponse extends ListResponse<Sample> {

    @JsonCreator
    public ListSamplesResponse(List<Sample> samples) {
        super(samples);
    }

}
