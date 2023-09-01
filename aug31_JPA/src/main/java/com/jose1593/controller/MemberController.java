package com.jose1593.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jose1593.entity.Member;
import com.jose1593.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService; // service 통과해서 repository로 가게끔
	
			
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		//Member(mno=0, mname=null, mid=Hima12, mpw=01234567, mjoindate=null)
		System.out.println(member);
		
		int count = memberService.count(member); // 이 member에서 몇 명이 사용해??
		System.out.println("카운트 : " + count);
		
		if(count == 1) { // count가 1이면
		Member result = memberService.findByMidAndMpw(member); // Service -> Repository로 값 보내주기
		
		System.out.println("name : " + result);
		session.setAttribute("id", result.getMid()); // 저장은 set
		session.setAttribute("name", result.getMname());
		
		// name : Member(mno=1, mname=짱아, mid=Hima12, mpw=01234567, mjoindate=2023-09-01T10:23:25)
		return "redirect:/index";
		}
		
				
		return "login";
	}
	

}
