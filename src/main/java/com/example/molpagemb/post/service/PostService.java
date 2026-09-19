package com.example.molpagemb.post.service;

import java.util.List;

import com.example.molpagemb.post.dto.CreatePostDTO;
import com.example.molpagemb.post.dto.PostDTO;
import com.example.molpagemb.post.dto.UpdatePostDTO;

public interface PostService {
	List<PostDTO> findAllPosts();
	List<PostDTO> findAllPostsByBoardId(Long boardId);
	List<PostDTO> findAllPostsByUserIdNumber(Long userIdNumber);
	PostDTO findPostByPostId(Long postId);
	void createPost(Long postBoardId, Long userIdNumber, CreatePostDTO createPostDTO);
	
	void updatePost(Long postId, UpdatePostDTO updatePostDTO);
	void deletePostByPostId(Long userIdNumber, Long postId);
	
	void deletePostByPostIdAdmin(Long postId);
}
