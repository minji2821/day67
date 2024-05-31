package com.itbank.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.BoardService;
import com.itbank.vo.BoardVO;


@Controller
@RequestMapping("/board")	//board 아래로 들어오는 모든 요청을 처리
public class Boardcontroller {
	
	@Autowired				//spring bean으로 등록된 객체를 하나 생성 받는 구문
	private BoardService bs;
	
	//게시글 전체 가져오기
	@GetMapping
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("ver",bs.getTest());		//view에서 출력할 데이터를 attribute에 담는다
		mav.addObject("list",bs.getBoards());
		mav.setViewName("board/list");		//출력할 view name을 지정
		
		return mav;
	}
	
	//게시글 작성폼
	@GetMapping("/write")
	public void write() {}

	
	// 게시글 작성 수행
	@PostMapping("/write")
	public String write(BoardVO input) {
		bs.addBoard(input);
		
		return "redirect:/";
	}
}
