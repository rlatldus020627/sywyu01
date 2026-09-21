package com.example.sywyu01.post.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostDTO {

	private Long postId;
	private Long postBoardId;
	private Long postUserIdNumber;
	private String postTitle;
	private String postContent;
	private LocalDateTime postCreatedAt;
}
