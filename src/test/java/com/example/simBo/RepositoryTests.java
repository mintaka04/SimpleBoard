package com.example.simBo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.simBo.board.Board;
import com.example.simBo.board.BoardRepository;
import com.example.simBo.comment.CommentRepository;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class RepositoryTests {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Test
	void test1_create() {
		
		Board b1 = new Board();
		b1.setTitle("유닛테스트 시작합니다");
		b1.setContent("테스트 글 내용입니다.");
		b1.setWrittenDate(LocalDateTime.now());
		this.boardRepository.save(b1);
		//this : 이 test1_create라는 메소드를 호출한 객체의 멤버인 boardRepository의
		//save 메소드를 사용하겠다.
		//실행 결과에 차이는 없다고 함. 다만 써주는게 더 명확하다고.
		
	}
	
	@Test
	void test2_read() {
		List<Board> all = this.boardRepository.findAll();
		assertEquals(1, all.size());
		
		Board b = all.get(0);
		assertEquals("유닛테스트 시작합니다", b.getTitle());
	}
	
	//테스트 할 때 findById 1씩 증가시켜줄 것
	@Test
	void test3_update() {
		Optional<Board> oq = this.boardRepository.findById(4);
		assertTrue(oq.isPresent());
		Board b = oq.get();
		b.setTitle("제목 수정합니다");
		this.boardRepository.save(b);
	}

	//테스트 할 때 findById 1씩 증가시켜줄 것
	@Test
	void test4_delete() {
		Optional<Board> oq = this.boardRepository.findById(4);
		assertTrue(oq.isPresent());
		Board b = oq.get();
		this.boardRepository.delete(b);
		assertEquals(0, this.boardRepository.count());
	}
	
}
