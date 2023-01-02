package com.example.simBo.board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.simBo.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	public List<Board> getList(){
		return this.boardRepository.findAll();
	}
	
	public Board getBoard(Integer boardNum) {
		Optional<Board> board = this.boardRepository.findById(boardNum);
		if(board.isPresent()) {
			return board.get();
		}else {
			throw new DataNotFoundException("board not found");
		}
	}
	
	public void create(String title, String content) {
		Board b = new Board();
		b.setTitle(title);
		b.setContent(content);
		b.setWrittenDate(LocalDateTime.now());
		this.boardRepository.save(b);
	}
	
	
}
