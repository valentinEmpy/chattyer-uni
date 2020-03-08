package chattyer.nlp.wit.client;

import chattyer.nlp.wit.WitContext;
import okhttp3.Request;

public interface WitRequest {

    Request get(WitContext witContext);

}
