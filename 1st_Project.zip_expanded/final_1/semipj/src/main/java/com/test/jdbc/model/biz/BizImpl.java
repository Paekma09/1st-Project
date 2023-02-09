package com.test.jdbc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;

import com.test.jdbc.model.dao.BoardMapper;
import com.test.jdbc.model.dto.BoardDto;
import com.test.jdbc.model.dto.CommentDto;

@Service
public class BizImpl implements Biz{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectList() {
		return boardMapper.selectList();
	}

	@Override
	public BoardDto selectOne(int boardSeq) {
		return boardMapper.selectOne(boardSeq);
	}

	
	@Override
	public int insert(BoardDto dto) {
		return boardMapper.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		return boardMapper.update(dto);
	}

	@Override
	public int delete(int boardSeq) {
		return boardMapper.delete(boardSeq);
	}

	@Override
	public int cntUpdate(int boardSeq) {
		return boardMapper.cntUpdate(boardSeq);
	}

	@Override
	public List<BoardDto> selectSortLike() {
		return boardMapper.selectSortLike();
	}

	@Override
	public int updateLike(int boardSeq) {
		return boardMapper.updateLike(boardSeq);
	}
	
	@Override
	public int cntComment(int boardSeq) {
		System.out.println(boardSeq+"2");
		return boardMapper.cntComment(boardSeq);
	}

	@Override
	public int insertComment(String content, String id, int boardSeq) {
		return boardMapper.insertComment(content, id, boardSeq);
	}

	@Override
	public List<CommentDto> selectCommentList(int boardSeq) {
		return boardMapper.selectCommentList(boardSeq);
	}

	@Override
	public List<BoardDto> noticeList() {
		return boardMapper.noticeList();
	}

	@Override
	public int delComment(int commentSeq) {
		return boardMapper.delComment(commentSeq);
	}

	
	

	
}