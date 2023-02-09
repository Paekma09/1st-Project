package com.boot.jdbc.model.biz;

import com.boot.jdbc.model.dto.SignUpDto;

public interface SignUpBiz {
	public int register(SignUpDto dto);
	public String idChk(String id);
}
