package com.boot.jdbc.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jdbc.model.dao.WorldCupMapper;
import com.boot.jdbc.model.dto.WorldCupDto;
@Service
public class WorldCupBizImpl implements WorldCupBiz {
     @Autowired
     private WorldCupMapper worldcupMapper;
     
	 @Override
	public List<WorldCupDto> selectList() {
		return worldcupMapper.selectList();
	}


}
