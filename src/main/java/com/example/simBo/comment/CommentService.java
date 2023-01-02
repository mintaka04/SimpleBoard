package com.example.simBo.comment;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.simBo.board.Board;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

	private final CommentRepository commentRepository;
	
	public void create(Board board, String content) {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setWrittenDate(LocalDateTime.now());
		comment.setBoard(board);
		this.commentRepository.save(comment);
	}
	
}
