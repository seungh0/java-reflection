package me.will;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {

	// Class Instance - Allocate in Heap Memory
	public static void main(String[] args) throws ClassNotFoundException {
		// Method 1
		Class<Book> bookClass = Book.class;

		// Method 2
		Book book = new Book();
		Class<? extends Book> aClass = book.getClass();

		// Method 3
		Class<?> forName = Class.forName("me.will.Book");

		System.out.println("==== get public Field === ");
		Arrays.stream(forName.getFields())
				.forEach(System.out::println);
		// public java.lang.String me.will.Book.d (get only public field)

		System.out.println("=== get DeclaredFields ===");
		Arrays.asList(forName.getDeclaredFields())
				.forEach(System.out::println);
		// get All field

		System.out.println("==== get All Field");
		Arrays.stream(forName.getDeclaredFields())
				.forEach(f -> {
					try {
						f.setAccessible(true); // 접근제어 무시
						System.out.printf("%s %s\n", f, f.get(book));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				});

		// Get Methods
		Arrays.stream(forName.getMethods())
				.forEach(System.out::println);

		System.out.println("== superclass ===");
		System.out.println(MyBook.class.getSuperclass()); // class me.will.Book

		System.out.println("==== interfacees ===");
		Arrays.stream(MyBook.class.getInterfaces())
				.forEach(System.out::println);

		System.out.println("==== is Public or static ===");
		Arrays.stream(Book.class.getDeclaredFields())
				.forEach(f -> {
					int modifiers = f.getModifiers();
					System.out.println(f);
					System.out.println(Modifier.isPublic(modifiers));
					System.out.println(Modifier.isStatic(modifiers));
				});
	}

}
