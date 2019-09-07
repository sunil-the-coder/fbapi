package com.fbapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.fbapi.model.Post;
import com.fbapi.repository.PostRepository;


@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private EmailService emailService;
	
	public List<Post> getAll() {
		return postRepository.findAll();

	}

	public Optional<Post> getPost(Long id) {
		return postRepository.findById(id);
	}

	// Inserts row into table
	public void addPost(Post post) {
	
	
		postRepository.save(post);
		
		//Email Trigger
		//EmailService.sendEmail("","","")
		//1. Get the user from post - PostService
		//2. Get the email from user - UserService
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("dvn.narewadkar@gmail.com");
		message.setTo("sunilnobeltraining@gmail.com");
		message.setText("When is back?");
		message.setSubject("There is comment from sunil");//+comment.getUser());;
		emailService.sendNotification(message);
		
		//Fetch User info from commented user
		
		

	}

	public void updatePost(Post post) {
		postRepository.save(post);

	}

	// Removes row from table
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}
}
