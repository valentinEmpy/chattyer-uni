package chattyer.core.messages;

public class Messages {

    private Messages() {
    }

    // EXCEPTION
    public static final String CHATBOT_DESCRIPTOR_FILE_NOT_SCHEMA_COMPLIANT = "Chatbot descriptor file content is not schema compliant";
    public static final String COULD_NOT_PARSE_CHATBOT_DESCRIPTOR = "Could not parse chatbot descriptor with error \"{0}\"";
    public static final String COULD_NOT_CONVERT_YAML_TO_JSON = "Could not convert yaml to json with error \"{0}\"";
    public static final String COULD_NOT_CONVERT_JSON_TO_YAML = "Could not convert json to yaml with error \"{0}\"";
    public static final String COULD_NOT_PARSE_JSON = "Could not parse json with error \"{0}\"";
    public static final String COULD_NOT_SERIALIZE_OBJECT = "Could not serialize object to json with error \"{0}\"";

    // ERRORS
    public static final String IDENTICAL_INTENTS_FOUND = "Multiple identical intents with value \"{0}\" found";
    public static final String INTENT_REFERENCED_BY_SAMPLE_DOES_NOT_EXIST = "Intent with value \"{0}\" referenced by a sample does not exist";
    public static final String INTENT_REFERENCED_BY_RESPONSE_DOES_NOT_EXIST = "Intent with value \"{0}\" referenced by a response does not exist";
    public static final String RESPONSES_REFERENCE_THE_SAME_INTENT = "Multiple responses reference the same intent - \"{0}\" which is not allowed";
    public static final String NAME_OF_CHATBOT_CONTAINS_FORBIDDEN_CHARS = "Name of chatbot \"{0}\" contains forbidden characters \"{1}\"";

}
