package chattyer.persistence.converters;

import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import chattyer.persistence.exceptions.ConversionException;
import chattyer.common.models.Response;

@Converter(autoApply = true)
public class ListResponseConverter implements AttributeConverter<List<Response>, String> {

    private static final String SPLIT_CHAR = ";";
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<Response> list) {
        try {
            return objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            throw new ConversionException(e, "An error occurred trying to serialize a List<Response> for storing it in the database");
        }
    }

    @Override
    public List<Response> convertToEntityAttribute(String string) {
        try {
            return objectMapper.readValue(string, new TypeReference<List<Response>>() {
            });
        } catch (JsonProcessingException e) {
            throw new ConversionException(e,
                                          "An error occurred trying to deserialize a String into a List<Response> while retrieving database data");
        }
    }

}
