package com.example.demo.vo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Comment")
@Data
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentID;
	private Integer userID;
	private Integer postID;
	private String content;
	private Timestamp createdAt;

	public Comment() {
		super();
	}

	public Comment(Integer commentID, Integer userID, Integer postID, String content, Timestamp createdAt) {
		super();
		this.commentID = commentID;
		this.userID = userID;
		this.postID = postID;
		this.content = content;
		this.createdAt = createdAt;
	}
}