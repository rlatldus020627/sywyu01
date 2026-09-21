package com.example.sywyu01.post.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sywyu01.post.dto.CreatePostDTO;
import com.example.sywyu01.post.dto.PostDTO;
import com.example.sywyu01.post.dto.UpdatePostDTO;
import com.example.sywyu01.post.repository.PostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
	private final PostMapper postMapper;
	
	@Override
	public List<PostDTO> findAllPosts() {
		return postMapper.findAllPosts();
	}

	@Override
	public List<PostDTO> findAllPostsByBoardId(Long boardId) {
		return postMapper.findAllPostsByBoardId(boardId);
	}

	@Override
	public List<PostDTO> findAllPostsByUserIdNumber(Long userIdNumber) {
		return postMapper.findAllPostsByUserIdNumber(userIdNumber);
	}

	@Override
	public PostDTO findPostByPostId(Long postId) {
		return postMapper.findPostByPostId(postId);
	}

	@Override
	public void createPost(Long postBoardId, Long userIdNumber, CreatePostDTO createPostDTO) {
		createPostDTO.setPostBoardId(postBoardId);
		createPostDTO.setPostUserIdNumber(userIdNumber);
		postMapper.savePost(createPostDTO);
	}

	@Override
	public void updatePost(Long postId, UpdatePostDTO updatePostDTO) {
		updatePostDTO.setPostId(postId);
		postMapper.updatePost(updatePostDTO);
		
	}

	@Override
	public void deletePostByPostId(Long userIdNumber, Long postId) {
		postMapper.deletePostByPostId(userIdNumber, postId);

		
	}

	@Override
	public void deletePostByPostIdAdmin(Long postId) {
		postMapper.deletePostByPostIdAdmin(postId);
	}

}
