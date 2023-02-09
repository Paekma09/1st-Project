package com.boot.jdbc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jdbc.model.dao.TalkMapper;
import com.boot.jdbc.model.dto.TalkDto;

@Service
public class TalkBizImpl implements TalkBiz{
	
	@Autowired
	private TalkMapper talkMapper;

	@Override
	public int insert(TalkDto talkDto) {
		return talkMapper.insert(talkDto);
	}

	@Override
	public List<TalkDto> selectList() {
		return talkMapper.selectList();
	}
}
