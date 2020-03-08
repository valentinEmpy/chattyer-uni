package chattyer.nlp.wit.client;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.text.MessageFormat;

import chattyer.nlp.wit.exceptions.WitRequestException;
import chattyer.nlp.wit.messages.Messages;
import chattyer.nlp.wit.WitContext;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

public class AbstractOperator {

    private WitContext witContext;

    public AbstractOperator(WitContext witContext) {
        this.witContext = witContext;
    }

    public <R> R executeAndMapResponse(Request request, ResponseMapper<R> responseMapper) {
        try (Response response = getWitContext().getHttpClient()
                                                .newCall(request)
                                                .execute()) {
            validateSuccessful(request, response);
            return responseMapper.map(response);
        } catch (IOException e) {
            throw new UncheckedIOException(MessageFormat.format("Failed executing request \"{0}\"", request), e);
        }
    }

    private void validateSuccessful(Request request, Response response) throws IOException {
        if (!response.isSuccessful()) {
            throw new WitRequestException(Messages.WIT_REQUEST_0_BODY_1_FAILED_RESPONSE_2_BODY_3,
                                          request,
                                          toString(request.body()),
                                          response,
                                          toString(response.body()));
        }
    }

    private String toString(RequestBody requestBody) throws IOException {
        if (requestBody == null) {
            return null;
        }
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return buffer.readUtf8();
    }

    private String toString(ResponseBody responseBody) throws IOException {
        if (responseBody == null) {
            return null;
        }
        return responseBody.string();
    }

    public int execute(Request request) {
        try (Response response = getWitContext().getHttpClient()
                                                .newCall(request)
                                                .execute()) {
            validateSuccessful(request, response);
            return response.code();
        } catch (IOException e) {
            throw new UncheckedIOException(MessageFormat.format("Failed executing request \"{0}\"", request), e);
        }
    }

    protected WitContext getWitContext() {
        return witContext;
    }

}
