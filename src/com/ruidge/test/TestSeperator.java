package com.ruidge.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSeperator {

	private static final String SEPERATOR = "-";

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("11111111");
		list.add("222222");
		list.add("aaaaaa");
		list.add("ssss");
		String s = list2String(list);
		System.out.println(s);
		System.out.println(string2List(s));
		System.out.println("====================");
		list.clear();
		list.add("haha");
		s = list2String(list);
		System.out.println(s);
		System.out.println(string2List(s));
	}

	private static String list2String(List<String> list) {
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		if (list != null) {
			for (String s : list) {
				if (isFirst) {
					isFirst = false;
				} else {
					sb.append(SEPERATOR);
				}
				sb.append(s);
			}
		}
		return sb.toString();
	}

	private static List<String> string2List(String str) {
		List<String> result = new ArrayList<String>();
		if (str != null) {
			String[] arrays = str.split(SEPERATOR);
			result.addAll(Arrays.asList(arrays));
		}
		return result;
	}
}
