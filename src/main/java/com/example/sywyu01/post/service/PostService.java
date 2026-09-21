package com.example.sywyu01.post.service;

import java.util.List;

import com.example.sywyu01.post.dto.CreatePostDTO;
import com.example.sywyu01.post.dto.PostDTO;
import com.example.sywyu01.post.dto.UpdatePostDTO;

public interface PostService {
	List<PostDTO> findAllPosts();
	List<PostDTO> findAllPostsByBoardId(Long boardId);
	List<PostDTO> findAllPostsByUserIdNumber(Long userIdNumber);
	PostDTO findPostByPostId(Long postId);
	void createPost(Long postBoardId, Long postUserIdNumber, CreatePostDTO createPostDTO);
	
	void updatePost(Long postId, UpdatePostDTO updatePostDTO);
	void deletePostByPostId(Long userIdNumber, Long postId);
	
	void deletePostByPostIdAdmin(Long postId);
}
