package com.chenly.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.Getter;
import lombok.Setter;

import java.io.Reader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2015/12/13.
 */
public class JsonUtil {
    private static Gson gson = new GsonBuilder().registerTypeAdapter(Date.class,new JsonDateSerializer())
                                                .registerTypeAdapter(Integer.class,new JsonIntegerSerializer())
                                                .registerTypeAdapter(BigDecimal.class,new JsonBigDecimalSerializer())
                                                .create();

    public static String toJson(Object obj){
        return gson.toJson(obj);
    }

    public static <T> T fromJson(String json,Class<T> t){
        return gson.fromJson(json, (Class<T>) t);
    }

    public static <T> T fromJson(String json,Type typeOfT){
        return gson.fromJson(json,typeOfT);
    }

    public static <T> T fromJson(Reader reader, Type typeOfT){
        return gson.fromJson(reader,typeOfT);
    }

    public static void main(String[] args) {
        String str = "[{\"name\":\"Liubo\",\"age\":30,\"date\":\"2015-12-13 15:58:48\"},{\"name\":\"Liubo\",\"age\":30,\"date\":\"2015-12-13 15:58:48\"}]";
        List<User> u = fromJson(str, new TypeToken<List<User>>(){}.getType());
        System.out.println(toJson(u));
    }

    @Setter
    @Getter
    private static class User {
        private String name;
        private Integer age;
        private Date date;
    }
}
