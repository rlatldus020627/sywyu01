package com.example.sywyu01.comment.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentDTO {
	private Long commentId;
	private Long commentPostId; 
	private Long commentUserIdNumber; 
	private String commentContent;
	private LocalDateTime commentCreatedAt;
}
