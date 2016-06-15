package com.ruidge.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class TestGson {
    public static void main(String[] args) {
        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("one", "hello");
        myMap.put("two", "world");

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(myMap);

        System.out.println(json);

        Type typeOfHashMap = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> newMap = gson.fromJson(json, typeOfHashMap); // This type must match TypeToken
        System.out.println(newMap.get("one"));
        System.out.println(newMap.get("two"));
    }
}
