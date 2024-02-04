package com.farhad.example.memento;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString
public class Article {

	private long id;
	private String title;
	private String content;
	public Article(long id, String title) {
		this.id = id;
		this.title = title;
	}

	public ArticleMemento createMemento() {
		return new ArticleMemento(id, title, content);
	}

	public void restore(ArticleMemento articleMemento) {
		this.id = articleMemento.getId();
		this.title = articleMemento.getTitle();
		this.content = articleMemento.getContent();
	}
	
}
