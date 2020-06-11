package com.ruidge.test;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class TestGsonAdapter {

    public static void main(String[] args) {

        Gson gson = new Gson();
//        Result1 result1 = gson.fromJson(jsonStr, Result1.class);
//        println(result1);
        Result2 result2 = gson.fromJson(jsonStr, Result2.class);
        println(result2);


    }

    static void println(Object obj) {
        System.out.println(new Gson().toJson(obj));
    }

    static String jsonStr = "{\n" +
            "    \"time\":\"20200611\",\n" +
            "    \"isBool\":1\n" +
            "}";


    class Result1 {
        String time;
        int isBool;
    }

    class Result2 {
        String time;
        @JsonAdapter(BooleanTypeAdapter.class)
        boolean isBool;
    }


    class BooleanTypeAdapter extends TypeAdapter<Boolean> {
        @Override
        public void write(JsonWriter out, Boolean value) throws IOException {
//            if (value == null) {
//                out.nullValue();
//            } else if (value) {
//                out.jsonValue("1");
//            } else {
//                out.jsonValue("0");
//            }
            out.value(value);
        }

        @Override
        public Boolean read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL || in.peek() == JsonToken.BEGIN_OBJECT || in.peek() == JsonToken.BEGIN_ARRAY) {
                return false;
            }
            String value = in.nextString();
            if (value.equalsIgnoreCase("1")) {
                return true;
            } else {
                return false;
            }
        }
    }
}
