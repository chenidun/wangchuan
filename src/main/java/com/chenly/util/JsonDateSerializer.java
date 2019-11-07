package com.chenly.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by user on 2015/12/13.
 */
public class JsonDateSerializer implements JsonSerializer<Date>, JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String dateText = jsonElement.getAsString();
        Date date = new Date();
        date.setTime(Long.parseLong(dateText));
        return date;
    }

    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        long dateText = date.getTime();
        return new JsonPrimitive(dateText);
    }
}
