package chattyer.core.handlers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import chattyer.common.models.ChatbotDescriptor;
import chattyer.nlp.wit.client.WitClient;
import chattyer.nlp.wit.client.samples.ImmutablePostSampleRequest;
import chattyer.nlp.wit.models.ImmutableEntityWithValue;
import chattyer.nlp.wit.models.ImmutableSample;
import chattyer.nlp.wit.models.PredefinedEntity;
import chattyer.nlp.wit.models.Sample;
import chattyer.persistence.models.WitApplication;

public class WitApplicationTrainer {

    private WitClient witClient;
    private ChatbotDescriptor chatbotDescriptor;

    public WitApplicationTrainer(WitClient witClient, ChatbotDescriptor chatbotDescriptor) {
        this.witClient = witClient;
        this.chatbotDescriptor = chatbotDescriptor;
    }

    public void train(WitApplication witApplication) {
        witClient.samples()
                 .post(ImmutablePostSampleRequest.builder()
                                                 .applicationId(witApplication.getId())
                                                 .samples(buildWitSamples(chatbotDescriptor))
                                                 .build());
    }

    private List<Sample> buildWitSamples(ChatbotDescriptor chatbotDescriptor) {
        return chatbotDescriptor.getSamples()
                                .stream()
                                .map(this::toWitSample)
                                .collect(Collectors.toList());
    }

    private Sample toWitSample(chattyer.common.models.Sample sample) {
        return ImmutableSample.builder()
                              .text(sample.getText())
                              .entities(buildEntitiesWithValue(sample))
                              .build();
    }

    private List<Sample.EntityWithValue> buildEntitiesWithValue(chattyer.common.models.Sample sample) {
        return Collections.singletonList(ImmutableEntityWithValue.builder()
                                                                 .entity(PredefinedEntity.INTENT)
                                                                 .value(sample.getIntent())
                                                                 .build());
    }

}
