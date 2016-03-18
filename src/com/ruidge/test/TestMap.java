package com.ruidge.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestMap {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        TestTestMap map = new TestTestMap();
        map.put(1, "a");
        map.put(2, "a");
        map.print();
        map.put(1, "b");
        map.put(1, "c");
        map.print();
    }

    public static class TestTestMap {
        private Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

        public List<String> get( Integer key ) {
            return map.get(key);
        }

        public void put( Integer key, List<String> ranges ) {
            map.put(key, ranges);
        }

        public void put( Integer key, String range ) {
            if (map.containsKey(key)) {
                map.get(key).add(range);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(range);
                map.put(key, list);
            }
        }

        public void print() {
            for (Entry<Integer, List<String>> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue().size());
            }
        }
    }

}
