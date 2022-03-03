package com.springboot.instagram.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.springboot.instagram.Entity.Comments;

public interface CommentRepo extends CrudRepository<Comments, Integer> {
	
	Comments save(Comments comment);
	ArrayList<Comments> findAllByPostId(String postId);
	ArrayList<Comments> findAll();
}
