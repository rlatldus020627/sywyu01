package com.example.sywyu01.post.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UpdatePostDTO {
	@JsonIgnore
	private Long postId;
	
	private String postTitle;
	private String postContent;
}
