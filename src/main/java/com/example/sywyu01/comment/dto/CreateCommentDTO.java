package com.example.sywyu01.comment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CreateCommentDTO {
	@JsonIgnore
	private Long commentId;
	
	@JsonIgnore
	private Long commentPostId;
	
	@JsonIgnore
	private Long commentUserIdNumber;
	
	private String commentContent;

}
