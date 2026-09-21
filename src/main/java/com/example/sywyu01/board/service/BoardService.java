package com.example.sywyu01.board.service;

import java.util.List;

import com.example.sywyu01.board.dto.BoardDTO;

public interface BoardService {
	List<BoardDTO> findAllBoards();
	BoardDTO findBoardByBoardId(Long boardId);
}
