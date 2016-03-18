package com.ruidge.test;

public class TestEnum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Color a = Color.RED;
		Color b = Color.RED;
		System.out.println(a);
		System.out.println(b.name());
		System.out.println(a.equals(b));
		System.out.println(a == b);

	}

	enum Color {
		RED, GREEN, BLUE
		
	}

}
