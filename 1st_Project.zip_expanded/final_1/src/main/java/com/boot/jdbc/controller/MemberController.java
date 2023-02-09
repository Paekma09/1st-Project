package com.boot.jdbc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.boot.jdbc.model.biz.MemberBiz;
import com.boot.jdbc.model.dto.MemberDto;


@Controller
public class MemberController {
	
	@Autowired
	private MemberBiz memberBiz;
	
	@RequestMapping("/loginform")
	public String loginform() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(HttpSession session, Model model, MemberDto dto) {

		Model res = model.addAttribute("memberDto",memberBiz.selectOne(dto));
		
		if(res != null) {
			session.setAttribute("login", res);
			return "/index";
		}else {
			return "redirect:/index";
		}
		
	}
	
	@GetMapping("/signupform")
	public ModelAndView signupform() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("signup");
		return mv;
	}
	
	@PostMapping("/signup")
	public String signup(MemberDto memberDto) {
		if(memberBiz.insert(memberDto) > 0) {
			return "/login";
		} else {
			return "redirect:/signupform";
		}
	}
	
}	
