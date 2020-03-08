package chattyer.nlp.wit.client;

import chattyer.nlp.wit.WitContext;

public interface PaginatedWitRequest extends WitRequest {

    PaginatedWitRequest getForNextPage(WitContext witContext);

}
