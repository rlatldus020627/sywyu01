package com.example.sywyu01.post.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sywyu01.common.utils.AuthUtil;
import com.example.sywyu01.post.dto.CreatePostDTO;
import com.example.sywyu01.post.dto.PostDTO;
import com.example.sywyu01.post.dto.UpdatePostDTO;
import com.example.sywyu01.post.service.PostService;
import com.example.sywyu01.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qwert/posts")
public class PostController {
	private final PostService postService;
	private final UserService userService;
	
	@GetMapping("/find-all-posts")
	public ResponseEntity<List<PostDTO>> findAllPosts(){
		return  ResponseEntity.ok(postService.findAllPosts());
		
	}
	
	@GetMapping("/find-all-posts-by-board-id/{postBoardId}")
	public ResponseEntity<List<PostDTO>> findAllPostsByBoardId(@PathVariable("postBoardId") Long boardId){
		return ResponseEntity.ok(postService.findAllPostsByBoardId(boardId));
		
	}

	@GetMapping("/find-all-posts-by-user-id-number/{userIdNumber}")
	public ResponseEntity<List<PostDTO>> findAllPostsByUserIdNumber(@PathVariable("userIdNumber") Long userIdNumber){
		return ResponseEntity.ok(postService.findAllPostsByUserIdNumber(userIdNumber));
	}
	
	@GetMapping("/find-post-by-post-id/{postId}")
	public ResponseEntity<PostDTO> findPostByPostId(@PathVariable("postId") Long postId){
		return ResponseEntity.ok(postService.findPostByPostId(postId));
	}
	
	@PostMapping("/post/{postBoardId}")
	public ResponseEntity<Map<String, Long>> createPost(@PathVariable("postBoardId") Long postBoardId, Authentication authentication, @RequestBody CreatePostDTO createPostDTO){
		Long userIdNumber = AuthUtil.getUserId(authentication);
		postService.createPost(postBoardId, userIdNumber, createPostDTO);
		if (createPostDTO.getPostId() == null) {
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity
				.status(201)
				.body(Map.of("postId", createPostDTO.getPostId()));
		
	}
	
	@PutMapping("/post/{postId}")
	public ResponseEntity<Void> updatePost(Principal principal, @PathVariable("postId") Long postId, @RequestBody UpdatePostDTO updatePostDTO){
		postService.updatePost(postId, updatePostDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/post/{postId}")
	public ResponseEntity<Void> deletePost(Principal principal, @PathVariable("postId") Long postId){
		Long userIdNumber = AuthUtil.getUserId(principal);
		if(userIdNumber == null) {
			return ResponseEntity.status(401).build();
		}
		postService.deletePostByPostId(userIdNumber, postId);
		return ResponseEntity.ok().build();
				
	}
}
