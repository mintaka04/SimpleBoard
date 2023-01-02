package com.example.simBo.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardController {
	
	private final BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Board> boardList = this.boardService.getList();
		model.addAttribute("boardList", boardList);
		return "board_list";
	}
	
	@GetMapping(value = "/detail/{boardNum}")
	public String detail(Model model, @PathVariable("boardNum") Integer num) {
		Board board = this.boardService.getBoard(num);
		model.addAttribute("board", board);
		return "board_detail";
	}
	
	@GetMapping("/create")
	public String boardCreate() {
		return "board_form";
	}
	
	@PostMapping("/create")
	public String boardCreate(@RequestParam String title, @RequestParam String content) {
		this.boardService.create(title, content);
		return "redirect:/board/list";
	}
	
}
