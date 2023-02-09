package com.boot.jdbc.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.jdbc.model.dto.SignUpDto;

@Mapper
public interface SignUpMapper {
	@Insert("INSERT INTO MEMBER VALUES(#{id}, #{pw}, #{name}, 'Y')")
	public int register(SignUpDto dto);
	
	@Select("SELECT ID FROM MEMBER WHERE ID=#{id}")
	public String idChk(String id);
}
