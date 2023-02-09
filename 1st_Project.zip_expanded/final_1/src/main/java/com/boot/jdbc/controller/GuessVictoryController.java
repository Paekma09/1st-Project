package com.boot.jdbc.controller;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.jdbc.model.biz.GuessVictoryBiz;
import com.boot.jdbc.model.dto.GuessVictoryDto;
import com.boot.jdbc.model.dto.MemberDto;

@Controller
@RequestMapping("/guessvictory")
public class GuessVictoryController {
	
	@Autowired
	private GuessVictoryBiz biz;
	
	@GetMapping("/list")
	public String selectList(HttpSession session, Model model) {
		
		session.setAttribute("login", new MemberDto("jiyoung3868", "password123", "박지영"));
		
		List<GuessVictoryDto> list = biz.selectList();
		List<String> dateList = new ArrayList<String>();
		List<String> weekList = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<String, String>();
	
		for(int i=0; i<list.size(); i++) {
			String date = list.get(i).getPlayDate();
			map.put("날짜", list.get(i).getPlayDate());
			map.put("요일", LocalDate.of(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5,7)), Integer.parseInt(date.substring(8,10))).getDayOfWeek().getDisplayName(TextStyle.NARROW, Locale.KOREA));
			dateList.add(list.get(i).getPlayDate());
			weekList.add(LocalDate.of(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(5,7)), Integer.parseInt(date.substring(8,10))).getDayOfWeek().getDisplayName(TextStyle.NARROW, Locale.KOREA));
		}
		
		dateList = dateList.stream().distinct().collect(Collectors.toList());
		weekList = weekList.stream().distinct().collect(Collectors.toList());
		
		LocalDate now = LocalDate.now();
		String today = now.toString();
		
		model.addAttribute("list", list);
		model.addAttribute("dateList", dateList);
		model.addAttribute("map", map);
		model.addAttribute("today", today);
		
		return "guessVictory";
	}
	
	@GetMapping("/ajaxVote1")
	@ResponseBody
	public String insertVote1(String nation1, String playTime, String playDate) {
		// 투표 여부
		String isvoted = biz.isVoted(playTime, playDate);
		
		// 투표하지 않은 경우
		if(isvoted.equals(" ")) {
			biz.insertVote1(nation1, playDate);
		} // 국가1로 선택을 바꾸고 싶은 경우
		else if(!isvoted.equals(nation1)) {
			biz.changeVote2To1(nation1, playDate);
		}

		// 득표율 보여주기
		return biz.getVoteRates1(playTime, playDate);
	}
	
	@GetMapping("/ajaxVote2")
	@ResponseBody
	public String insertVote2(String nation2, String playTime, String playDate) {
		// 투표 여부
		String isvoted = biz.isVoted(playTime, playDate);
		
		// 투표하지 않은 경우
		if(isvoted.equals(" ")) {
			biz.insertVote2(nation2, playDate);
		} // 국가2로 선택을 바꾸고 싶은 경우
		else if(!isvoted.equals(nation2)) {
			biz.changeVote1To2(nation2, playDate);
		}

		// 득표율 보여주기
		return biz.getVoteRates2(playTime, playDate);
	}
}
