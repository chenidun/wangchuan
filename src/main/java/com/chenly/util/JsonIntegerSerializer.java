package com.chenly.util;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;

/**
 * Created by user on 2015/12/13.
 */
public class JsonIntegerSerializer implements JsonSerializer<Integer>, JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String strText = jsonElement.getAsString();
        if (StringUtils.isBlank(strText)){
            return null;
        }
        return jsonElement.getAsInt();
    }

    @Override
    public JsonElement serialize(Integer integer, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(integer);
    }
}
