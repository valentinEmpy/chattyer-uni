package chattyer.nlp.wit.analyses;

import chattyer.nlp.wit.models.AnalysedMessage;
import chattyer.nlp.wit.models.Response;
import com.fasterxml.jackson.annotation.JsonCreator;

public class AnalyseMessageResponse extends Response<AnalysedMessage> {

    @JsonCreator
    public AnalyseMessageResponse(AnalysedMessage analysedMessage) {
        super(analysedMessage);
    }

}
