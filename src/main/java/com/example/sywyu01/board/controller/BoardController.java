package com.example.sywyu01.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sywyu01.board.dto.BoardDTO;
import com.example.sywyu01.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qwert/boards")
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/find-all-boards")
	public ResponseEntity<List<BoardDTO>> findAllBoards(){
		return ResponseEntity.ok(boardService.findAllBoards());
	}
	
	@GetMapping("/find-board-by-board-id")
	public ResponseEntity<BoardDTO> findBoardByBoardId(Long boardId){
		return ResponseEntity.ok(boardService.findBoardByBoardId(boardId));
	}
	

}
