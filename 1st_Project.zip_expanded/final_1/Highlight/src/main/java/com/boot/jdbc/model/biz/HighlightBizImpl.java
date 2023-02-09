package com.boot.jdbc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jdbc.model.dao.MyBoardMapper;
import com.boot.jdbc.model.dto.HighlightCommentDto;
import com.boot.jdbc.model.dto.HighlightDto;
import com.boot.jdbc.model.page.PagingVO;

@Service
public class HighlightBizImpl implements HighlightBiz{
	
	@Autowired
	private MyBoardMapper myBoardMapper;

	@Override
	public List<HighlightDto> selectList() {
		return myBoardMapper.selectList();
	}

	@Override
	public HighlightDto selectOne(int myno) {
		return myBoardMapper.selectOne(myno);
	}

	@Override
	public int insert(HighlightDto dto) {
		return myBoardMapper.insert(dto);
	}

	@Override
	public int update(HighlightDto dto) {
		return myBoardMapper.update(dto);
	}

	@Override
	public int delete(int hino) {
		return myBoardMapper.delete(hino);
	}
	
	@Override
	public int insertComment(HighlightCommentDto dto) {
		return myBoardMapper.insertComment(dto);
	}

	@Override
	public List<HighlightCommentDto> selectCommentList(int hino) {
		return myBoardMapper.selectCommentList(hino);
	}
	
	@Override
	public int updateCount(int hino) {
		return myBoardMapper.updateCount(hino);
	}

	@Override
	public int deleteAllComment(int hino) {
		return myBoardMapper.deleteAllComment(hino);
	}

	@Override
	public int countBoard() {
		return myBoardMapper.countBoard();
	}

	@Override
	public List<HighlightDto> selectBoard(PagingVO pvo) {
		return myBoardMapper.selectBoard(pvo);
	}
	
	@Override
	public int deleteComment(int hino) {
		return myBoardMapper.deleteComment(hino);
	}

	@Override
	public int commentCount(int hino) {
		return myBoardMapper.commentCount(hino);
	}
	
	


}
