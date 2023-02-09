package com.boot.jdbc.model.biz;

import java.util.List;

import com.boot.jdbc.model.dto.HighlightCommentDto;
import com.boot.jdbc.model.dto.HighlightDto;
import com.boot.jdbc.model.page.PagingVO;

public interface HighlightBiz {
	
	public List<HighlightDto>selectList();
	public HighlightDto selectOne(int hino);
	public int insert(HighlightDto dto);
	public int update(HighlightDto dto);
	public int delete(int hino);
	public int updateCount(int hino);
	int insertComment(HighlightCommentDto dto);
	public List<HighlightCommentDto> selectCommentList(int hino);
	int deleteAllComment(int hino);
	public int countBoard();
	public List<HighlightDto> selectBoard(PagingVO pvo);
	int deleteComment(int cono);
	int commentCount(int hino);
	
}
