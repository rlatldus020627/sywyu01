package com.example.molpagemb.post.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.molpagemb.post.dto.CreatePostDTO;
import com.example.molpagemb.post.dto.PostDTO;
import com.example.molpagemb.post.dto.UpdatePostDTO;


@Mapper
public interface PostMapper {
	List<PostDTO> findAllPosts(); //모든 글 조회
	List<PostDTO> findAllPostsByBoardId(Long boardId); //선택한 게시판의 모든 글 조회
	List<PostDTO> findAllPostsByUserIdNumber(Long userIdNumber); //선택한 유저의 모든 글 조회
	
	PostDTO findPostByPostId(Long postId); //선택한 게시글ID의 게시글 하나 조회
	
	void savePost(CreatePostDTO createPostDTO); //게시글 작성
	void updatePost(UpdatePostDTO updatePostDTO); //게시글 수정
	
	void deletePostByPostID(@Param("postId") Long postId, @Param("userIdNumber") Long userIdNumber); //내가 작성한 글 삭제
	void deletePostByPostIdAdmin(Long postId); //게시글 삭제(관리자 전용 권한)
	
	
}
