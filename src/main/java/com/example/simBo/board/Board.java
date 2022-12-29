package com.example.simBo.board;

import java.time.LocalDateTime;
import java.util.List;

import com.example.simBo.comment.Comment;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="board")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_num", nullable = false)
	private Integer boardNum;
	
	@Column(name="written_date", columnDefinition="timestamp default CURRENT_TIMESTAMP", nullable = false )
	private LocalDateTime writtenDate;
	
	@Column(name="title", columnDefinition="varchar(50)")
	private String title;
	
	@Column(name="content", columnDefinition="text")
	private String content;
	
	@OneToMany(mappedBy="board", cascade=CascadeType.REMOVE)
	private List<Comment> commentList;
	//게시물에서 코멘트를 참조하기 위함.
	
	
}
