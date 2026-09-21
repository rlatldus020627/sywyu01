package com.example.sywyu01.post.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CreatePostDTO {
	@JsonIgnore
	private Long postId;
	
	@JsonIgnore
	private Long postUserIdNumber;

	@JsonIgnore
	private Long postBoardId;

	private String postTitle;
	private String postContent;
	
}
