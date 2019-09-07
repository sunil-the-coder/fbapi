package com.fbapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long postId;
	
	private String UserName;
	private String postName;
	
	@CreatedDate
	private Date date;
	private String message;
	private String type;
	private String privacy;
	private String title;
	
	@OneToMany
	@JoinColumn
	private List<Comment> comments;
	
	
	

}
