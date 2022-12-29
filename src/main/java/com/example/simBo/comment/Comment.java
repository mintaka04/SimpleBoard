package com.example.simBo.comment;

import java.time.LocalDateTime;

import com.example.simBo.board.Board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="comment_num", nullable=false)
	private Integer commentNum;
	
	@Column(name="written_date", columnDefinition="timestamp default CURRENT_TIMESTAMP", nullable = false )
	private LocalDateTime writtenDate;
	
	@Column(columnDefinition = "text")
	private String content;
	
	@ManyToOne
	private Board board;
	
}
