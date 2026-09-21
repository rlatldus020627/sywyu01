package com.example.sywyu01.comment.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sywyu01.comment.dto.CommentDTO;
import com.example.sywyu01.comment.dto.CreateCommentDTO;

@Mapper
public interface CommentMapper {
	List<CommentDTO> findAllComments(); //모든 댓글 조회
	List<CommentDTO> findAllCommentsByPostId(Long postId);//선택한 게시글의 모든 댓글 조회
	List<CommentDTO> findAllCommentsByUserIdNumber(Long userIdNumber);//선택한 유저의 모든 댓글 조회
	CommentDTO findCommentByCommentId(Long commentId);//선택한 하나의 댓글 조회
	
	void saveComment(Long commentUserIdNumber, Long commentPostId, CreateCommentDTO createCommentDTO);
	
	void deleteComment(Long commentId);

}
