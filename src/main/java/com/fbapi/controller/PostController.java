package com.fbapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fbapi.model.Post;
import com.fbapi.service.PostService;


@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public List<Post> getPost() {
		return postService.getAll();
	}
    
	// ------------ Retrieve a single post ------------
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public Optional<Post> getPost(@PathVariable Long id) {
			return postService.getPost(id);
		}
		
		// ------------ Create a post ------------
		@RequestMapping(value = "/createPost", method = RequestMethod.POST)
		public void addPost(@RequestBody Post post) {
			postService.addPost(post);
			
		}
    
		// ------------ Update a post ------------
		@RequestMapping(value = "/updatePost", method = RequestMethod.PUT)
		public void updatePost(@RequestBody Post post) {
			postService.updatePost(post);
		}
		
		// ------------ Delete a post------------
		@RequestMapping(value = "/deletePost/{id}", method = RequestMethod.DELETE)
		public void deletePost(@PathVariable Long id) {
			postService.deletePost(id);
		}
    
    

}
