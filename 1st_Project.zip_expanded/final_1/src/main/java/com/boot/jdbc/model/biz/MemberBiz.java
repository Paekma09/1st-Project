package com.boot.jdbc.model.biz;

import com.boot.jdbc.model.dto.MemberDto;

public interface MemberBiz {
	public MemberDto selectOne(MemberDto memberDto);
	public int insert(MemberDto memberDto);
}
