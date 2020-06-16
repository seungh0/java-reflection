package me.will;

public class Book {

	public static String A = "A";

	private String B = "B";

	public Book() {
	}

	public Book(String b) {
		B = b;
	}

	private void c() {
		System.out.println("Method C()");
	}

	public int sum(int left, int right) {
		return left + right;
	}

}
