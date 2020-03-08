package chattyer.web.exception.handling;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import chattyer.web.messages.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import chattyer.core.exceptions.ParsingException;
import chattyer.core.exceptions.SchemaValidationException;
import chattyer.core.exceptions.ValidationException;
import chattyer.nlp.wit.exceptions.WitRequestException;
import chattyer.web.exceptions.EntityAlreadyExistsException;
import chattyer.web.exceptions.EntityNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger EXCEPTION_LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<RestApiError> handleAccessDenied(AccessDeniedException exception) {
        logException(exception);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                             .body(ImmutableRestApiError.builder()
                                                        .type(exception.getClass()
                                                                       .getSimpleName())
                                                        .message(Messages.ERROR_ACCESS_HAS_BEEN_DENIED)
                                                        .build());
    }

    @ExceptionHandler({ BadCredentialsException.class })
    public ResponseEntity<RestApiError> handleBadCredentials(BadCredentialsException exception) {
        logException(exception);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                             .body(ImmutableRestApiError.builder()
                                                        .type(exception.getClass()
                                                                       .getSimpleName())
                                                        .message(Messages.ERROR_INVALID_CREDENTIALS)
                                                        .build());
    }

    @ExceptionHandler({ ParsingException.class })
    public ResponseEntity<RestApiError> handleParsingException(ParsingException exception) {
        logException(exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(ImmutableRestApiError.builder()
                                                        .type(exception.getClass()
                                                                       .getSimpleName())
                                                        .message(exception.getMessage())
                                                        .build());
    }

    @ExceptionHandler({ SchemaValidationException.class, ValidationException.class })
    public ResponseEntity<RestApiError> handleValidationException(ValidationException exception) {
        logException(exception);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(ImmutableRestApiError.builder()
                                                        .type(exception.getClass()
                                                                       .getSimpleName())
                                                        .message(exception.getMessage())
                                                        .subErrors(getRestApiSchemaValidationErrors(exception))
                                                        .build());
    }

    private List<RestApiSchemaValidationError> getRestApiSchemaValidationErrors(ValidationException exception) {
        return exception.getValidationErrors()
                        .stream()
                        .map(validationError -> ImmutableRestApiSchemaValidationError.builder()
                                                                                     .message(validationError)
                                                                                     .build())
                        .collect(Collectors.toList());
    }

    @ExceptionHandler({ PersistenceException.class })
    public ResponseEntity<RestApiError> handlePersistenceException(PersistenceException exception) {
        logException(exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ImmutableRestApiError.builder()
                                                        .type(exception.getClass()
                                                                       .getSimpleName())
                                                        .message(Messages.ERROR_UNEXPECTED_PERSISTENCE_ERROR)
                                                        .build());
    }

    @ExceptionHandler({ EntityNotFoundException.class })
    public ResponseEntity<RestApiError> handleNotFound(EntityNotFoundException exception) {
        logException(exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(ImmutableRestApiError.builder()
                                                        .type(exception.getClass()
                                                                       .getSimpleName())
                                                        .message(exception.getMessage())
                                                        .build());
    }

    @ExceptionHandler({ EntityAlreadyExistsException.class })
    public ResponseEntity<RestApiError> handleConflict(EntityAlreadyExistsException exception) {
        logException(exception);
        return ResponseEntity.status(HttpStatus.CONFLICT)
                             .body(ImmutableRestApiError.builder()
                                                        .type(exception.getClass()
                                                                       .getSimpleName())
                                                        .message(exception.getMessage())
                                                        .build());
    }

    @ExceptionHandler({ WitRequestException.class })
    public ResponseEntity<RestApiError> handleWitRequestException(WitRequestException exception) {
        logException(exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ImmutableRestApiError.builder()
                                                        .type(exception.getClass()
                                                                       .getSimpleName())
                                                        .message(Messages.ERROR_UNEXPECTED_COMMUNICATION_ERROR_WITH_EXTERNAL_DEPENDENCIES)
                                                        .build());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        logException(exception);
        RestApiError error = ImmutableRestApiError.builder()
                                                  .type(exception.getClass()
                                                                 .getSimpleName())
                                                  .message(Messages.ERROR_VALIDATION_REQUEST_INPUT)
                                                  .subErrors(getRestApiValidationErrors(exception))
                                                  .build();
        return ResponseEntity.badRequest()
                             .body(error);
    }

    private List<RestApiValidationError> getRestApiValidationErrors(MethodArgumentNotValidException exception) {
        return exception.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(fieldError -> ImmutableRestApiValidationError.builder()
                                                                          .field(fieldError.getField())
                                                                          .message(fieldError.getDefaultMessage())
                                                                          .value(fieldError.getRejectedValue())
                                                                          .build())
                        .collect(Collectors.toList());
    }

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<RestApiError> handleRuntimeException(RuntimeException exception) {
        logException(exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ImmutableRestApiError.builder()
                                                        .type(exception.getClass()
                                                                       .getSimpleName())
                                                        .message(Messages.ERROR_UNEXPECTED_ERROR)
                                                        .build());
    }

    private static void logException(Throwable t) {
        EXCEPTION_LOGGER.error("An error has occurred while serving REST request", t);
    }

}
