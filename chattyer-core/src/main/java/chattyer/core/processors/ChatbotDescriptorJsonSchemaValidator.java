package chattyer.core.processors;

import java.io.IOException;
import java.io.UncheckedIOException;

import chattyer.core.exceptions.SchemaValidationException;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import chattyer.core.exceptions.InternalParsingException;
import chattyer.core.messages.Messages;
import chattyer.core.util.Utils;

public class ChatbotDescriptorJsonSchemaValidator {

    public void validate(String json) {
        JsonSchema schema = getJsonSchema();
        JsonNode jsonNode = Utils.toJsonNode(json);
        ProcessingReport report = validate(schema, jsonNode);
        if (!report.isSuccess()) {
            throw buildSchemaValidationException(report);
        }
    }

    private JsonSchema getJsonSchema() {
        try {
            JsonNode schemaNode = JsonLoader.fromResource("/chatbot_descriptor_schema.json");
            return JsonSchemaFactory.byDefault()
                                    .getJsonSchema(schemaNode);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (ProcessingException e) {
            throw new InternalParsingException(e,
                                               e.getProcessingMessage()
                                                .getMessage());
        }
    }

    private ProcessingReport validate(JsonSchema schema, JsonNode json) {
        try {
            return schema.validate(json, true);
        } catch (ProcessingException e) {
            throw buildSchemaValidationException(e, e.getProcessingMessage());
        }
    }

    private SchemaValidationException buildSchemaValidationException(Throwable t, ProcessingMessage processingMessage) {
        SchemaValidationException schemaValidationException = new SchemaValidationException(t,
                                                                                            Messages.CHATBOT_DESCRIPTOR_FILE_NOT_SCHEMA_COMPLIANT);
        schemaValidationException.addError(processingMessage.getMessage());
        return schemaValidationException;
    }

    private SchemaValidationException buildSchemaValidationException(ProcessingReport report) {
        SchemaValidationException schemaValidationException = new SchemaValidationException(Messages.CHATBOT_DESCRIPTOR_FILE_NOT_SCHEMA_COMPLIANT);
        for (ProcessingMessage processingMessage : report) {
            schemaValidationException.addError(processingMessage.getMessage());
        }
        return schemaValidationException;
    }

}
