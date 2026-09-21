package com.example.sywyu01.comment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sywyu01.comment.dto.CommentDTO;
import com.example.sywyu01.comment.repository.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
	private final CommentMapper commentMapper;
	
	@Override
	public List<CommentDTO> findAllComments() {
		return commentMapper.findAllComments();
	}

	@Override
	public List<CommentDTO> findAllCommentsByPostId(Long postId) {
		return commentMapper.findAllCommentsByPostId(postId);
	}

	@Override
	public List<CommentDTO> findAllCommentsByUserIdNumber(Long userIdNumber) {
		return commentMapper.findAllCommentsByUserIdNumber(userIdNumber);
	}

	@Override
	public CommentDTO findCommentByCommentId(Long commentId) {
		// TODO Auto-generated method stub
		return commentMapper.findCommentByCommentId(commentId);
	}

	@Override
	public void saveComment(Long commentuserIdNumber, Long commentPostId) {
		// TODO Auto-generated method stub
		
	}

}
