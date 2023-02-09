package com.test.jdbc.model.dto;

import java.util.Date;


/*CREATE TABLE IF NOT EXISTS `batman`.`board` (
		  `board_seq` INT NOT NULL AUTO_INCREMENT,
		  `title` VARCHAR(100) NOT NULL,
		  `content` TEXT NOT NULL,
		  `reg_date` DATETIME NOT NULL,
		  `update_date` DATETIME NOT NULL,
		  `read_count` INT NOT NULL DEFAULT '0',
		  `like` INT NOT NULL DEFAULT '0',
		  `id` VARCHAR(100) NOT NULL,
		  PRIMARY KEY (`board_seq`))
		ENGINE = InnoDB
		DEFAULT CHARACTER SET = utf8mb4
		COLLATE = utf8mb4_0900_ai_ci;*/

public class BoardDto {

	private int boardSeq;
	private String title;
	private String content;
	private Date regDate;
	private Date updateDate;
	private int readCount;
	private int like;
	private String id;
	private int cntComment;
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardDto(int boardSeq, String title, String content, Date regDate, Date updateDate, int readCount, int like,
			String id, int cntComment) {
		super();
		this.boardSeq = boardSeq;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.readCount = readCount;
		this.like = like;
		this.id = id;
		this.cntComment = cntComment;
	}
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCntComment() {
		return cntComment;
	}
	public void setCntComment(int cntComment) {
		this.cntComment = cntComment;
	}
	
}
