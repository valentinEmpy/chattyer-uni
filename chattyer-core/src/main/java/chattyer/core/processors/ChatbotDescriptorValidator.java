package chattyer.core.processors;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import chattyer.common.models.visitors.ChatbotDescriptorVisitor;
import chattyer.core.exceptions.ValidationException;
import chattyer.core.messages.Messages;
import chattyer.common.models.ChatbotDescriptor;
import chattyer.common.models.Intent;
import chattyer.common.models.Response;
import chattyer.common.models.Sample;

public class ChatbotDescriptorValidator implements ChatbotDescriptorVisitor {

    private static final String FORBIDDEN_NAME_CHARACTERS = " 1234567890-+=/!@#$%^&*()'\"\\<>,.?";
    private List<Intent> intents;
    private List<Response> responses;
    private List<String> validationErrors;

    public synchronized void validate(ChatbotDescriptor chatbotDescriptor) {
        init();
        validateChatbotName(chatbotDescriptor.getName());
        chatbotDescriptor.accept(this);
        if (!validationErrors.isEmpty()) {
            throw new ValidationException("Error validating chatbot descriptor", validationErrors);
        }
    }

    private void init() {
        intents = new ArrayList<>();
        responses = new ArrayList<>();
        validationErrors = new ArrayList<>();
    }

    private void validateChatbotName(String chatbotName) {
        List<Character> forbiddenCharactersViolated = new ArrayList<>();
        for (Character forbiddenChar : FORBIDDEN_NAME_CHARACTERS.toCharArray()) {
            if (chatbotName.contains(forbiddenChar.toString())) {
                forbiddenCharactersViolated.add(forbiddenChar);
            }
        }
        if (!forbiddenCharactersViolated.isEmpty()) {
            validationErrors.add(MessageFormat.format(Messages.NAME_OF_CHATBOT_CONTAINS_FORBIDDEN_CHARS, chatbotName,
                                                      forbiddenCharactersViolated.stream()
                                                                                 .map(String::valueOf)
                                                                                 .collect(Collectors.joining(""))));
        }
    }

    @Override
    public void visit(Intent intent) {
        if (intents.stream()
                   .anyMatch(it -> it.getName()
                                     .equalsIgnoreCase(intent.getName()))) {
            validationErrors.add(MessageFormat.format(Messages.IDENTICAL_INTENTS_FOUND, intent.getName()));
        }
        intents.add(intent);
    }

    @Override
    public void visit(Sample sample) {
        if (intents.stream()
                   .noneMatch(intent -> intent.getName()
                                              .equalsIgnoreCase(sample.getIntent()))) {
            validationErrors.add(MessageFormat.format(Messages.INTENT_REFERENCED_BY_SAMPLE_DOES_NOT_EXIST, sample.getIntent()));
        }
    }

    @Override
    public void visit(Response response) {
        if (intents.stream()
                   .noneMatch(intent -> intent.getName()
                                              .equalsIgnoreCase(response.getIntent()))) {
            validationErrors.add(MessageFormat.format(Messages.INTENT_REFERENCED_BY_RESPONSE_DOES_NOT_EXIST, response.getIntent()));
        }
        if (responses.stream()
                     .anyMatch(itResponse -> itResponse.getIntent()
                                                       .equalsIgnoreCase(response.getIntent()))) {
            validationErrors.add(MessageFormat.format(Messages.RESPONSES_REFERENCE_THE_SAME_INTENT, response.getIntent()));
        }
        responses.add(response);
    }
}
