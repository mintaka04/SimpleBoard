package com.example.simBo.comment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.simBo.board.Board;
import com.example.simBo.board.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/comment")
@RequiredArgsConstructor
@Controller
public class CommentController {
	
	private final BoardService boardService;
	private final CommentService commentService;
	
	@PostMapping("/create/{commentNum}")
	public String createComment(Model model, @PathVariable("commentNum") Integer id,
			@RequestParam String content, 
			@Valid CommentForm commentForm, BindingResult bindingResult) {
		
		Board board = this.boardService.getBoard(id);

		if(bindingResult.hasErrors()) {
			model.addAttribute("board", board);
			return "board_detail";
		}
		
		this.commentService.create(board, commentForm.getContent());
		return String.format("redirect:/board/detail/%s", id);
	}
	
}
