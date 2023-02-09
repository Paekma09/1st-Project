package com.test.jdbc.model.biz;

import java.util.List;

import com.test.jdbc.model.dto.BoardDto;
import com.test.jdbc.model.dto.CommentDto;

public interface Biz {
	public List<BoardDto> selectList();
	public List<BoardDto> selectSortLike();
	public BoardDto selectOne(int boardSeq);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int boardSeq);
	public int cntUpdate(int boardSeq);
	public int updateLike(int boardSeq);
	public int insertComment(String content, String id, int boardSeq);
	public List<CommentDto> selectCommentList(int boardSeq);
	public List<BoardDto> noticeList();
	public int cntComment(int boardSeq);
	public int delComment(int commentSeq);
} 