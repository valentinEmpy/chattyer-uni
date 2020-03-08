package chattyer.web.messages;

public class Messages {

    private Messages() {
    }

    // EXCEPTION
    public static final String USERNAME_0_IS_ALREADY_TAKEN = "The username \"{0}\" is already in use";
    public static final String ORGANIZATION_WITH_ID_0_DOES_NOT_EXIST = "Organization with id \"{0}\" does not exist";
    public static final String USER_WITH_USERNAME_0_NOT_FOUND = "User with username \"{0}\" has not been found";
    public static final String SPACE_WITH_ID_0_DOES_NOT_EXIST = "Space with id \"{0}\" does not exist";
    public static final String ROLE_WITH_ID_0_DOES_NOT_EXIST = "Role with id \"{0}\" does not exist";
    public static final String ROLE_COVERING_THIS_ACCESS_PERMISSIONS_ALREADY_EXISTS = "A role covering this access already exists";
    public static final String WIT_APPLICATION_WITH_ID_0_NOT_FOUND = "Wit application with id \"{0}\" not found";
    public static final String CHATBOT_WITH_ID_0_NOT_FOUND = "Chatbot with id \"{0}\" not found";

    // ERROR
    public static final String ERROR_VALIDATION_REQUEST_INPUT = "Invalid input";
    public static final String ERROR_ACCESS_HAS_BEEN_DENIED = "Access has been denied";
    public static final String ERROR_UNEXPECTED_PERSISTENCE_ERROR = "An unexpected error associated with the persistence has occurred";
    public static final String ERROR_UNEXPECTED_COMMUNICATION_ERROR_WITH_EXTERNAL_DEPENDENCIES = "An unexpected error has occurred while communicating with external dependencies";
    public static final String ERROR_UNEXPECTED_ERROR = "An unexpected error has occurred";
    public static final String ERROR_INVALID_CREDENTIALS = "Invalid credentials have been provided";

    // WEBSOCKET
    public static final String ERROR_COULD_NOT_EXECUTE_REMOTE_CALL = "Error getting answer while trying to execute a remote request that failed with status code: \"{0}\"";
    public static final String COULD_NOT_UNDERSTAND = "Sorry, I could not understand you.";
    public static final String COULD_UNDERSTAND_BUT_CANNOT_ANSWER = "Sorry, I can understand you but I have not been taught how to answer that!";

}
