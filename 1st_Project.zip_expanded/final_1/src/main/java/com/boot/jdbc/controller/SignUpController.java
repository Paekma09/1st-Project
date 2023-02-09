package com.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.jdbc.model.biz.SignUpBiz;
import com.boot.jdbc.model.dto.SignUpDto;

@Controller
@RequestMapping("/signup")
public class SignUpController {
   
   @Autowired
   private SignUpBiz biz;
   
   @GetMapping("/signupform")
   public String memberRegister() {
      return "signUp";
   }
   
   @PostMapping("/register")
   public String register(SignUpDto dto) {
      biz.register(dto);
      
      return "login";
   }
   
   @PostMapping("/idChk")
   @ResponseBody
   public int ajaxIdChk(String id) {
      
      String res = biz.idChk(id);
      if(res!=null) {
         return 1;
      }else {
         return 0;
      }
      
   }
}