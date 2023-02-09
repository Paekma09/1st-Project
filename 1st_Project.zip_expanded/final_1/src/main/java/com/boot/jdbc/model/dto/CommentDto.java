package com.boot.jdbc.model.dto;

import java.util.Date;
/*
 * CREATE TABLE IF NOT EXISTS `batman`.`board_comment` (
  `comment_seq` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(1000) NOT NULL,
  `reg_date` DATETIME NOT NULL,
  `id` VARCHAR(100) NOT NULL,
  `board_seq` INT NOT NULL,
  PRIMARY KEY (`comment_seq`),
  INDEX `fk_board_comment_board1_idx` (`board_seq` ASC) VISIBLE,
  CONSTRAINT `fk_board_comment_board1`
    FOREIGN KEY (`board_seq`)
    REFERENCES `batman`.`board` (`board_seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;*/
 
public class CommentDto {

	private int commentSeq;
	private String content;
	private Date regDate;
	private String id;
	private int boardSeq;
	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentDto(int commentSeq, String content, Date regDate, String id, int boardSeq) {
		super();
		this.commentSeq = commentSeq;
		this.content = content;
		this.regDate = regDate;
		this.id = id;
		this.boardSeq = boardSeq;
	}
	public int getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

}
