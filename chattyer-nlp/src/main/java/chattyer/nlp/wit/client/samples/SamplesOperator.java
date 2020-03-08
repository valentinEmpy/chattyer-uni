package chattyer.nlp.wit.client.samples;

public interface SamplesOperator {

    ListSamplesResponse list(ListSamplesRequest request);

    void post(PostSampleRequest request);

    void delete(DeleteSampleRequest request);

}
