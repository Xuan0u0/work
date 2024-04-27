package com.example.demo.vo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Post")
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postID;
	private Integer userID;
	private String content;
	private byte[] image;
	private Timestamp createdAt;

	public Post() {
		super();
	}

	public Post(Integer postID, Integer userID, String content, byte[] image, Timestamp createdAt) {
		super();
		this.postID = postID;
		this.userID = userID;
		this.content = content;
		this.image = image;
		this.createdAt = createdAt;
	}
}