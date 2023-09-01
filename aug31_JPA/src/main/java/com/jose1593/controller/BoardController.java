package com.jose1593.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jose1593.entity.JBoard;
import com.jose1593.entity.Member;
import com.jose1593.service.BoardService;
import com.jose1593.service.MemberService;

@Controller
public class BoardController {
	
	@Autowired
	private MemberService memberService; // service 통과해서 repository로 가게끔

	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board(Model model) {
		List<JBoard> list = boardService.findAll(); // boardService 갔을 때 repository랑 연결하게
		model.addAttribute("list", list);
		return "board"; // 게시글 다 찍어줘
	}

	@GetMapping("/write") // 글쓰기 제목, 본문, 내용 값이 들어옴
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(JBoard jBoard, HttpSession session) {
		
		if(session.getAttribute("id") != null) {
			Member member = memberService.findByMid((String)session.getAttribute("id")); // 로그인 한 사람만
			// 글 쓴 사람이 누구인지 찾아냄 jBoard에 붙여주고 jBoard에 저장
			
			jBoard.setMember(member);
			boardService.save(jBoard);
		}
		
		return "redirect:/board";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(name="bno", required = true) int bno, Model model) { // bno 값 반드시 들어와야됨
		JBoard detail = boardService.findByBno(bno);
		model.addAttribute("detail", detail);
		
		return "detail";
		
	}
}
