package com.example.sywyu01.comment.service;

import java.util.List;

import com.example.sywyu01.comment.dto.CommentDTO;
import com.example.sywyu01.comment.dto.CreateCommentDTO;

public interface CommentService {
	List<CommentDTO> findAllComments(); // 모든 댓글 조회
	List<CommentDTO> findAllCommentsByPostId(Long postId); //선택한 게시글의 모든 댓글 조회
	List<CommentDTO> findAllCommentsByUserIdNumber(Long userIdNumber); //선택한 유저의 모든 댓글 조회
	CommentDTO findCommentByCommentId(Long commentId); //선택한 댓글 하나 조회
	
	void saveComment(Long commentPostId, Long commentUserIdNumber, CreateCommentDTO createCommentDTO);
}
