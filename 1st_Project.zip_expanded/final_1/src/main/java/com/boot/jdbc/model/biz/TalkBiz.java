package com.boot.jdbc.model.biz;

import java.util.List;

import com.boot.jdbc.model.dto.TalkDto;

public interface TalkBiz {
	public int insert(TalkDto talkDto);
	public List<TalkDto> selectList();
}
