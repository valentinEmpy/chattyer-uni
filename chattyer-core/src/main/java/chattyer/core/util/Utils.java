package chattyer.core.util;

import chattyer.core.exceptions.ParsingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import chattyer.core.messages.Messages;

public class Utils {

    private static final ObjectMapper YAML_OBJECT_MAPPER = new ObjectMapper(new YAMLFactory());
    private static final ObjectMapper JSON_OBJECT_MAPPER = new ObjectMapper();

    private Utils() {
    }

    public static String fromYamlToJson(String yaml) {
        try {
            JsonNode jsonNode = YAML_OBJECT_MAPPER.readTree(yaml);
            return JSON_OBJECT_MAPPER.writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            throw new ParsingException(e, Messages.COULD_NOT_CONVERT_YAML_TO_JSON, e.getMessage());
        }
    }

    public static String fromJsonToYaml(String json) {
        try {
            JsonNode jsonNode = JSON_OBJECT_MAPPER.readTree(json);
            return YAML_OBJECT_MAPPER.writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            throw new ParsingException(e, Messages.COULD_NOT_CONVERT_JSON_TO_YAML, e.getMessage());
        }
    }

    public static JsonNode toJsonNode(String json) {
        try {
            return JSON_OBJECT_MAPPER.readTree(json);
        } catch (JsonProcessingException e) {
            throw new ParsingException(e, Messages.COULD_NOT_PARSE_JSON, e.getMessage());
        }
    }

}
