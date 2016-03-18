package com.ruidge.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datatest {

	public static void main(String[] args) {
		Date d = new Date(1436382001929l);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(d);
		System.out.println(format);
	}
}
