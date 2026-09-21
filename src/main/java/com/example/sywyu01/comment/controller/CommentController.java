package com.example.sywyu01.comment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sywyu01.comment.dto.CommentDTO;
import com.example.sywyu01.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qwert/comments")
public class CommentController {
	private final CommentService commentService;
	
	@GetMapping("/find-all-comments")
	public ResponseEntity<List<CommentDTO>> findAllComments(){
		return ResponseEntity.ok(commentService.findAllComments());
	}
	
	@GetMapping("/find-all-comments-by-post-id")
	public ResponseEntity<List<CommentDTO>> findAllCommentsByPostId(Long postId){
		return ResponseEntity.ok(commentService.findAllCommentsByPostId(postId));
	}
	
	@GetMapping("/find-all-comments-by-user-id-number")
	public ResponseEntity<List<CommentDTO>> findAllCommentsByUserIdNumber(Long userIdNumber){
		return ResponseEntity.ok(commentService.findAllCommentsByUserIdNumber(userIdNumber));
	}
	
	@GetMapping("/find-comment-by-comment-id")
	public ResponseEntity<CommentDTO> findCommentByCommentId(Long commentId){
		return ResponseEntity.ok(commentService.findCommentByCommentId(commentId));
	}
}
