package com.boot.jdbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.jdbc.model.biz.HighlightBiz;
import com.boot.jdbc.model.dto.HighlightCommentDto;
import com.boot.jdbc.model.dto.HighlightDto;
import com.boot.jdbc.model.dto.MemberDto;
import com.boot.jdbc.model.page.PagingVO;

@Controller
@RequestMapping("/Highlightboard")
public class MyBoardController {
	
	@Autowired
	private HighlightBiz highlightBiz;
	
	/*
	@GetMapping("/list")
	public String selectList(Model model) {
		model.addAttribute("list", highlightBiz.selectList());
		return "Highlightboardlist";
	}
	*/
	
	@GetMapping("/insertform")
	public String insertForm() {
		return "Highlightboardinsert";
	}
	
	@PostMapping("/insert")
	public String insert(HighlightDto dto) {
		if(highlightBiz.insert(dto)>0) {
			return"redirect:/Highlightboard/list";
		}else {
				return "redirect:/Highlightboard/insertform";
		}
		
	
	}
	
	@GetMapping("/detail")
	public String selectOne(Model model, int hino) {
		highlightBiz.updateCount(hino);
		model.addAttribute("dto",highlightBiz.selectOne(hino));
		model.addAttribute("coList", highlightBiz.selectCommentList(hino) );
		
		return "Highlightboarddetail";
	}
	
	@GetMapping("/updateform")
	public String updateform(Model model,int hino) {
		model.addAttribute("dto",highlightBiz.selectOne(hino));
		return"Highlightboardupdate";
	}
	
	@PostMapping("/update")
	public String update(HighlightDto dto) {
		if(highlightBiz.update(dto)>0) {
			return "redirect:/Highlightboard/detail?hino="+dto.getHino();
		}else {
			return "redirect:/Highlightboard/updateform?hino="+dto.getHino();
		}
	}
	
	@GetMapping("/delete")
	public String delete(int hino) {
		
		highlightBiz.deleteAllComment(hino);
		
		if(highlightBiz.delete(hino)>0) {
			return"redirect:/Highlightboard/list";
			
		}else {
			return"redirect:/Highlightboard/detail?hino="+hino;
		}
	}
	
	@GetMapping("/list2")
	public String selectList2() {
		return "list";
	}
	
	@PostMapping("/insertcomment")
	public String insertComment(HighlightCommentDto dto) {
		System.out.println("insertcomment");
		if(highlightBiz.insertComment(dto)>0) {
			return "redirect:/Highlightboard/detail?hino=" + dto.getHino();
		}else {
			System.out.println("댓글작성실패");
			return "redirect:/Highlightboard/detail?hino=" + dto.getHino();
		}
		
	}
	
	@GetMapping("/list")
	public String selectList(HttpSession session, PagingVO pvo, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		
		// !!!!!!!!!!!!!!!! 로그인 기능 연동후 삭제할 코드
//		session.setAttribute("login", "admin");
		session.setAttribute("login", new MemberDto("admin","1234","관리자"));
		
		int total = highlightBiz.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "7";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "7";
		}
		pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		
		model.addAttribute("paging", pvo);
		List<HighlightDto> list = highlightBiz.selectBoard(pvo);
		
		for(int i=0; i<list.size(); i++) {
			list.get(i).setCommentcount(highlightBiz.commentCount(list.get(i).getHino()));
		}
		model.addAttribute("list",list);
		return "Highlightboardlist";
	}
	
	@GetMapping("/deletecomment")
	public String deleteComment(int cono, int hino) {
		System.out.println(cono + ": " + hino);
		if(highlightBiz.deleteComment(cono)>0) {
			return"redirect:/Highlightboard/detail?hino="+hino;
		}else {
			return"redirect:/Highlightboard/detail?hino="+hino;
		}
	}

}
