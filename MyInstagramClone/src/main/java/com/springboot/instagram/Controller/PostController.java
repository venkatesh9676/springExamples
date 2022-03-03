package com.springboot.instagram.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.Entity.Post;
import com.springboot.instagram.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	
	@Autowired 
	PostService postService;
	@PostMapping
	private Post submitUserPost(@RequestBody Post post) {
		return postService.submitPostToDB(post);
	}
	
	@GetMapping("/post")
	private ArrayList<Post> getAllPost() {
		return postService.retrivePostFromDB();
	}
}
