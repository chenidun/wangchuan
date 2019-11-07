package com.chenly.util;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * Created by deng on 2017/11/16.
 */
public class JsonBigDecimalSerializer implements JsonSerializer<BigDecimal>, JsonDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String strText = jsonElement.getAsString();
        if (StringUtils.isBlank(strText)){
            return null;
        }
        return new BigDecimal(strText.trim());
    }

    @Override
    public JsonElement serialize(BigDecimal bigDecimal, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(bigDecimal);
    }
}
