package com.example.sywyu01.board.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardDTO {
	private Long boardId;
	private String boardName;
	private LocalDateTime boardCreatedAt;
}
