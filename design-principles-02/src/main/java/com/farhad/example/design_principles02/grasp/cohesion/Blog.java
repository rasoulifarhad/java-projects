package com.farhad.example.design_principles02.grasp.cohesion;

import java.util.ArrayList;
import java.util.List;

// In a blogging platform, the Blog class should only be responsible for managing blog-related activities, such as adding 
// and removing posts, and not for handling user authentication.
public class Blog {

	private List<Post> posts;

	public Blog() {
		posts = new ArrayList<>();
	}

	public void addPost(Post post) {
		posts.add(post);
	}

	public void removePost(Post post) {
		posts.remove(post);
	}

	
}
