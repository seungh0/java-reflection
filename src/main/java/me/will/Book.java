package me.will;

@MyAnnotation(number = 100)
public class Book {

	@MyAnnotation(name = "seungho", number = 10) // 컴파일 에러 X (Target 설정)
	private String a = "a";

	private static String B = "BOOK";

	private static final String C = "BOOK";

	@AnotherAnnotation
	public String d = "d";

	protected String e = "e";

	@AnotherAnnotation
	public Book() {
	}

	//	@MyAnnotation // 컴파일 에러 (Target x)
	public Book(String a, String d, String e) {
		this.a = a;
		this.d = d;
		this.e = e;
	}

	@AnotherAnnotation
	private void f() {
		System.out.println("F");
	}

	public void g() {
		System.out.println("g");
	}

	public int h() {
		return 100;
	}

}
