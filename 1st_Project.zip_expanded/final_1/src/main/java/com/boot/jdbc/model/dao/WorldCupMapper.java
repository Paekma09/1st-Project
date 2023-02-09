package com.boot.jdbc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.boot.jdbc.model.dto.WorldCupDto;

@Mapper
public interface WorldCupMapper {
@Select("SELECT*FROM WORLDCUP")
List<WorldCupDto> selectList();
}
