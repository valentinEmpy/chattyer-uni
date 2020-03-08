package chattyer.common.models.visitors;

import chattyer.common.models.Intent;
import chattyer.common.models.Response;
import chattyer.common.models.Sample;

public interface ChatbotDescriptorVisitor {

    void visit(Intent intent);

    void visit(Sample sample);

    void visit(Response response);

}
