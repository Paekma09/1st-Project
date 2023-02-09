package com.boot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.WorldCupBiz;

@Controller
@RequestMapping("/WorldCup")
public class WorldCupController {

@Autowired
private WorldCupBiz worldbiz;

@GetMapping("/list")
public String selectList(Model model) {
	model.addAttribute("list",worldbiz.selectList());
	return "NewFile";
}
@GetMapping("/preview")
public String preview(Model model) {
	return "preview";
}

}