package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer UserID;
	private String UserName;
	private String Email;
	private String Password;
	private String CoverImage;
	private String Biography;

	public User() {
		super();
	}

	public User(Integer userID, String userName, String email, String password, String coverImage, String biography) {
		super();
		UserID = userID;
		UserName = userName;
		Email = email;
		Password = password;
		CoverImage = coverImage;
		Biography = biography;
	}
}