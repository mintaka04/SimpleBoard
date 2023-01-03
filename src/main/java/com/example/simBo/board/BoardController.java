package com.example.simBo.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.simBo.comment.CommentForm;

import jakarta.validation.Valid;
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
	public String detail(Model model, @PathVariable("boardNum") Integer num, 
							CommentForm commentForm) {
		Board board = this.boardService.getBoard(num);
		model.addAttribute("board", board);
		return "board_detail";
	}
	
	@GetMapping("/create")
	public String boardCreate(BoardForm boardForm) {
		return "board_form";
	}
	
	@PostMapping("/create")
	public String boardCreate(@Valid BoardForm boardForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "board_form";
		}
		this.boardService.create(boardForm.getTitle(), boardForm.getContent());
		return "redirect:/board/list";
	}
	
}
