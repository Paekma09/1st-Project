package com.boot.jdbc.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jdbc.model.dao.MemberMapper;
import com.boot.jdbc.model.dto.MemberDto;


@Service
public class MemberBizImpl implements MemberBiz{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberDto selectOne(MemberDto memberDto) {
		return memberMapper.selectOne(memberDto);
	}

	@Override
	public int insert(MemberDto memberDto) {
		return memberMapper.insert(memberDto);
	}

}
