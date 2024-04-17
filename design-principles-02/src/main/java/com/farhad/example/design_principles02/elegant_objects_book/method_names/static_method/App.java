package com.farhad.example.design_principles02.elegant_objects_book.method_names.static_method;

public class App {

	public static void main(String[] args) {
		{
			String html = StaticWebPage.read("http://wwww.java.com");
			System.out.println(html);
		}

		{
			String html = new WebPage("http://wwww.java.com")
					.content();
			System.out.println(html);
		}
	}
}
