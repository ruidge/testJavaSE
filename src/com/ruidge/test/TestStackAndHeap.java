package com.ruidge.test;

public class TestStackAndHeap {

	public static void main(String[] args) {
		TestStackAndHeap self = new TestStackAndHeap();
		self.circle(10);
	}

	private void circle(int i) {
		if (i > 0) {
			System.out.println(i + "");
			circle(i + 1);
		} else {
			System.out.println("out");
		}
	}

}
