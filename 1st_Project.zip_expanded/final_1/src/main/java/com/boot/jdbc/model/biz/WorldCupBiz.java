package com.boot.jdbc.model.biz;

import java.util.List;

import com.boot.jdbc.model.dto.WorldCupDto;

public interface WorldCupBiz {
public List<WorldCupDto> selectList();
}
