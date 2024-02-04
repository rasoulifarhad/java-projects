package com.farhad.example.memento;

import lombok.Value;

@Value
public class ArticleMemento {

	private long id;
	private String Title;
	private String content;

}
