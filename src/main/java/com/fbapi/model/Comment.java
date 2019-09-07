package com.fbapi.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "post_id", nullable = false)
//	private Post post;
	
	private String comment;
	private String userName;
	@CreatedDate
	private LocalDateTime commentDate;
	
}
