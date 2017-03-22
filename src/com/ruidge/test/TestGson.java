package com.ruidge.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
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

        String resultStr = "{\n" +
                "\t\"resultCode\": 123,\n" +
                "\t\"resultMsg\": \"successadfasdfs\",\n" +
                "\t\"result\": [{\n" +
                "\t\t\"normalRisk\": 15,\n" +
                "\t\t\"id\": 106,\n" +
                "\t\t\"time\": \"2016-06-28\",\n" +
                "\t\t\"userName\": \"梁新姣\",\n" +
                "\t\t\"highRisk\": 25,\n" +
                "\t\t\"lowRisk\": 10,\n" +
                "\t\t\"productName\": \"记健康基因检测\",\n" +
                "\t\t\"bindStatus\": 3,\n" +
                "\t\t\"status\": 1\n" +
                "\t}, {\n" +
                "\t\t\"normalRisk\": 15,\n" +
                "\t\t\"id\": 44,\n" +
                "\t\t\"time\": \"2016-06-28\",\n" +
                "\t\t\"userName\": \"我叫新报告\",\n" +
                "\t\t\"highRisk\": 25,\n" +
                "\t\t\"lowRisk\": 10,\n" +
                "\t\t\"productName\": \"记健康基因检测\",\n" +
                "\t\t\"bindStatus\": 5,\n" +
                "\t\t\"status\": 4\n" +
                "\t}, {\n" +
                "\t\t\"normalRisk\": 15,\n" +
                "\t\t\"id\": 68,\n" +
                "\t\t\"time\": \"2016-06-27\",\n" +
                "\t\t\"userName\": \"梁新姣\",\n" +
                "\t\t\"highRisk\": 25,\n" +
                "\t\t\"lowRisk\": 10,\n" +
                "\t\t\"productName\": \"记健康基因检测\",\n" +
                "\t\t\"bindStatus\": 5,\n" +
                "\t\t\"status\": 2\n" +
                "\t}, {\n" +
                "\t\t\"normalRisk\": 15,\n" +
                "\t\t\"id\": 66,\n" +
                "\t\t\"time\": \"2016-06-27\",\n" +
                "\t\t\"userName\": \"梁新姣\",\n" +
                "\t\t\"highRisk\": 25,\n" +
                "\t\t\"lowRisk\": 10,\n" +
                "\t\t\"productName\": \"记健康基因检测\",\n" +
                "\t\t\"bindStatus\": 5,\n" +
                "\t\t\"status\": 3\n" +
                "\t}, {\n" +
                "\t\t\"normalRisk\": 15,\n" +
                "\t\t\"id\": 69,\n" +
                "\t\t\"time\": \"2016-06-27\",\n" +
                "\t\t\"userName\": \"梁新姣\",\n" +
                "\t\t\"highRisk\": 25,\n" +
                "\t\t\"lowRisk\": 10,\n" +
                "\t\t\"productName\": \"记健康基因检测\",\n" +
                "\t\t\"bindStatus\": 5,\n" +
                "\t\t\"status\": 5\n" +
                "\t}]\n" +
                "}";

        ChildResult result = gson.fromJson(resultStr, ChildResult.class);

//        System.out.println(result.toString());

        String testFloat = "{\"a\":\"-1\",\"b\":\"1.3\"}";

        TestFloat tf = gson.fromJson(testFloat, TestFloat.class);

        System.out.println(tf);

    }


    class TestFloat {
        //可以没有setter,getter;
        private float a;
        private String b;

        @Override
        public String toString() {
            return "TestFloat{" +
                    "a=" + a +
                    ", b='" + b + '\'' +
                    '}';
        }
    }

    class Result {
        //可以没有setter,getter;
        protected String resultCode;
        protected String resultMsg;

    }

    class ChildResult extends Result {
        private JsonArray result;

        @Override
        public String toString() {
            return "ChildResult{" +
                    "resultCode=" + resultCode +
                    "resultMsg=" + resultMsg +
                    "result=" + result +
                    '}';
        }
    }
}
