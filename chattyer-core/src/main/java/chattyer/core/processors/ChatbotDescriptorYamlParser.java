package chattyer.core.processors;

import chattyer.core.exceptions.ParsingException;
import chattyer.core.messages.Messages;
import chattyer.core.util.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

import chattyer.common.models.ChatbotDescriptor;

public class ChatbotDescriptorYamlParser implements Parser<ChatbotDescriptor> {

    private ChatbotDescriptorJsonSchemaValidator schemaValidator = new ChatbotDescriptorJsonSchemaValidator();
    private ChatbotDescriptorValidator validator = new ChatbotDescriptorValidator();

    @Override
    public ChatbotDescriptor parse(String chatbotDescriptorYaml) {
        String chatbotDescriptorJson = Utils.fromYamlToJson(chatbotDescriptorYaml);
        schemaValidator.validate(chatbotDescriptorJson);
        ChatbotDescriptor chatbotDescriptor = parseChatbotDescriptorJson(chatbotDescriptorJson);
        validator.validate(chatbotDescriptor);
        return chatbotDescriptor;
    }

    private ChatbotDescriptor parseChatbotDescriptorJson(String chatbotDescriptorJson) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new GuavaModule());
            return objectMapper.readValue(chatbotDescriptorJson, ChatbotDescriptor.class);
        } catch (JsonProcessingException e) {
            throw new ParsingException(e, Messages.COULD_NOT_PARSE_CHATBOT_DESCRIPTOR, e.getMessage());
        }
    }

}
