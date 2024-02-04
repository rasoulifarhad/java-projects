package com.farhad.example.memento;

public class ArticleCaretaker {

	public static void main(String[] args) {
		Article article = new Article(1, "My Article");
		article.setContent("ABC");

		ArticleMemento articleMemento = article.createMemento();
		article.setContent("123");
		System.out.println(article);

		article.restore(articleMemento);
		System.out.println(article);
	}
}
