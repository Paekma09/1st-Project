package com.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.jdbc.model.biz.Biz;
import com.boot.jdbc.model.dto.BoardDto;
import com.boot.jdbc.model.dto.CommentDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
		public String goLogin() {
		return "login";
	}
	
	@Autowired
	private Biz Biz;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		model.addAttribute("list", Biz.selectList());
		model.addAttribute("notice", Biz.noticeList());
		model.addAttribute("like", Biz.selectSortLike());
		
		return "boardlist";
	}
	
	@GetMapping("/insertform")
	public String insertForm() {
		return "boardinsert";
	}
	
	@PostMapping("/insert")
	public String insert(BoardDto dto) {
		if(Biz.insert(dto) > 0) {
			return "redirect:/board/list";
		}else {
			return "redirect:/board/insertform";
		}
	}
	
	@GetMapping("/detail")
	public String selectOne(Model model, int boardSeq) {
		Biz.cntUpdate(boardSeq);
		model.addAttribute("dto", Biz.selectOne(boardSeq));
		model.addAttribute("comment", Biz.selectCommentList(boardSeq));
		return "boarddetail";
	}
	
	@GetMapping("/updateform")
	public String updateForm(Model model, int boardSeq) {
		model.addAttribute("dto", Biz.selectOne(boardSeq));
		return "boardupdate";
	}
	
	@PostMapping("/update")
	public String update(BoardDto dto) {
		if(Biz.update(dto) > 0) {
			return "redirect:/board/detail?boardSeq="+dto.getBoardSeq();
		}else {
			return "redirect:/board/updateform?boardSeq="+dto.getBoardSeq();
		}
	}
	
	@GetMapping("/delete")
	public String delete(int boardSeq) {
		if(Biz.delete(boardSeq)>0) {
			return "redirect:/board/list";
		}else {
			System.out.println("해당 게시물을 삭제할 수 없습니다.");
			return "redirect:/baord/list";
		}
	}
	
	
	@GetMapping("/updatelike")
	public String updateLike(int boardSeq) {
		
		Biz.updateLike(boardSeq); 
		
		return "redirect:/board/detail?boardSeq="+ boardSeq;
	}
	
	@GetMapping("/cntComment")
	public String cntComment(int boardSeq) {
		Biz.cntComment(boardSeq); 
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/insertcomment")
	public String insertComment(String content, String id, int boardSeq) {
		if(Biz.insertComment(content, id, boardSeq)>0) {
			return "redirect:/board/detail?boardSeq=" + boardSeq;
		}else {
			return "redirect:/board/detail?boardSeq=" + boardSeq;
		}
		
	}
	
	@GetMapping("/delcomment")
	public String delComment(int commentSeq, int boardSeq) {
		Biz.delComment(commentSeq);
		return "redirect:/board/detail?boardSeq="+ boardSeq;
	}
	
	
	
	
	
	
}
