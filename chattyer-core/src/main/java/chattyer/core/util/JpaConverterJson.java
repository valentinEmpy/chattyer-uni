package chattyer.core.util;

import java.io.IOException;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import chattyer.core.exceptions.ParsingException;
import chattyer.core.messages.Messages;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter
public class JpaConverterJson implements AttributeConverter<Object, String> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Object meta) {
        try {
            return OBJECT_MAPPER.writeValueAsString(meta);
        } catch (JsonProcessingException e) {
            throw new ParsingException(e, Messages.COULD_NOT_SERIALIZE_OBJECT, e.getMessage());
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        try {
            return OBJECT_MAPPER.readValue(dbData, Object.class);
        } catch (IOException e) {
            throw new ParsingException(e, Messages.COULD_NOT_PARSE_JSON, e.getMessage());
        }
    }

}
