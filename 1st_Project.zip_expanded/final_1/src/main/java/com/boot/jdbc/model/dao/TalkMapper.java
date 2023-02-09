package com.boot.jdbc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.jdbc.model.dto.TalkDto;

@Mapper
public interface TalkMapper {
	
	@Insert(" INSERT INTO TALK VALUES(NULL, #{id}, #{name}, #{tcontent}, #{tdate}) ")
	int insert(TalkDto talkDto);
	
	@Select(" SELECT * FROM TALK ORDER BY TNO ASC ")
	List<TalkDto> selectList();
}
