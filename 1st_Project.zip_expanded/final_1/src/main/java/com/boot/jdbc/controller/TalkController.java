package com.boot.jdbc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;

import com.boot.jdbc.model.biz.TalkBiz;
import com.boot.jdbc.model.dto.TalkDto;

@Controller
public class TalkController {
	
	@Autowired
	private TalkBiz talkBiz;
	
	@ResponseBody
	@PostMapping("/talk_db")
	public void talk_db(@RequestBody TalkDto talkDto) {
		talkBiz.insert(talkDto);
	}
	
	@ResponseBody
	@PostMapping("/talkView")
	public List<TalkDto> talkView(Model model) {
		List<TalkDto> list = talkBiz.selectList();
		return list;
	}
}
