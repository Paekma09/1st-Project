package com.boot.jdbc.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jdbc.model.dao.SignUpMapper;
import com.boot.jdbc.model.dto.SignUpDto;

@Service
public class SignUpBizImpl implements SignUpBiz{

	@Autowired
	private SignUpMapper mapper;
	
	@Override
	public int register(SignUpDto dto) {
		return mapper.register(dto);
	}

	@Override
	public String idChk(String id) {
		return mapper.idChk(id);
	}

	
}
