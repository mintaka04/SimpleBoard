package com.example.simBo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.simBo.board.Board;
import com.example.simBo.board.BoardRepository;
import com.example.simBo.comment.CommentRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
class RepositoryTests {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Test
	void testCreate() {
		
		Board b1 = new Board();
		b1.setTitle("유닛테스트 시작합니다");
		b1.setContent("테스트 글 내용입니다.");
		b1.setWrittenDate(LocalDateTime.now());
		this.boardRepository.save(b1);
		
	}
	
	@Test
	void testRead() {
		List<Board> all = this.boardRepository.findAll();
		assertEquals(1, all.size());
		
		Board b = all.get(0);
		assertEquals("유닛테스트 시작합니다", b.getTitle());
	}
	
	@Test
	void testUpdate() {
		Optional<Board> oq = this.boardRepository.findById(3);
		assertTrue(oq.isPresent());
		Board b = oq.get();
		b.setTitle("제목 수정합니다");
		this.boardRepository.save(b);
	}

	@Test
	void testDelete() {
		Optional<Board> oq = this.boardRepository.findById(3);
		assertTrue(oq.isPresent());
		Board b = oq.get();
		this.boardRepository.delete(b);
		assertEquals(0, this.boardRepository.count());
	}
	
}
