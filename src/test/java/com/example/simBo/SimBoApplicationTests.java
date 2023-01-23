package com.example.simBo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.simBo.board.BoardService;

@SpringBootTest
class SimBoApplicationTests {

	@Autowired
	private BoardService boardService;
	
	@Test
	void testJpa() {
		for(int i = 1; i <= 300; i++) {
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content= "내용없음";
			this.boardService.create(subject, content);
		}
	}

}
