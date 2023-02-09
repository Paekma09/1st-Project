package com.boot.jdbc.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.jdbc.model.dto.MemberDto;


@Mapper
public interface MemberMapper {
	
	@Select(" SELECT * FROM MEMBER WHERE ID=#{id} AND PASSWORD=#{password} ")
	MemberDto selectOne(MemberDto memberDto);
	
	@Insert(" INSERT INTO MEMBER VALUES(#{id}, #{password}, #{name}) ")
	int insert(MemberDto memberDto);
}
