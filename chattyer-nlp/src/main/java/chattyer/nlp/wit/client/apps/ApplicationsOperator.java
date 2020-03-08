package chattyer.nlp.wit.client.apps;

public interface ApplicationsOperator {

    ListApplicationsResponse list();

    GetApplicationResponse get(GetApplicationRequest request);

    PostApplicationResponse post(PostApplicationRequest request);

    void delete(DeleteApplicationRequest request);

}
