package br.com.pocketbase.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class JsonConverter {

    private final static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
//        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    }

    public static <R> R fromJson(String json, Class<R> container, Class... classe) throws IOException {
        if (Objects.isNull(json) || "".equals(json)) {
            return null;
        }

        if (Objects.isNull(classe)) {
            return objectMapper.readValue(json, container);
        }

        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(container, classe);
        return objectMapper.readValue(json, javaType);
    }

    public static String toJson(Object o) throws IOException {
        return objectMapper.writeValueAsString(o);
    }

}
