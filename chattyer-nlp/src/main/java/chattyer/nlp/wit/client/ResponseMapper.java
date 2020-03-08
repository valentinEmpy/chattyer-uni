package chattyer.nlp.wit.client;

import java.io.IOException;

import okhttp3.Response;

public interface ResponseMapper<R> {

    R map(Response response) throws IOException;

}
