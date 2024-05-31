package com.itbank.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.exception.LoginException;
import com.itbank.service.AccountService;
import com.itbank.vo.AccountVO;

import oracle.jdbc.proxy.annotation.Post;


@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService as;
	
	//전체 (*Account 테이블) 파일 다 가져오는 것
	@GetMapping 
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list",as.getAccounts());
		mav.setViewName("account/list");
		
		return mav;
	}
	
	//로그인 폼(입력하는 것)
	@GetMapping("/login")
	public void login() {}
	
	//로그인 수행 - 실패 시 예외 발생
	@PostMapping("/login")
	public String login(AccountVO input, HttpSession session)
			throws LoginException, NoSuchAlgorithmException {
				
		//session: 웹브라우저 종료 시까지 유지되는 객체, 주로 로그인 유지에 사용
		session.setAttribute("user", as.login(input));
		return "redirect:/";
	}
	
	//로그아웃 수행
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	//회원가입 폼
	@GetMapping("/signUp")
	public void signUp() {}
	
	//회원가입 수행
	@PostMapping("/signUp")
	public String signUp(AccountVO input) 
		throws NoSuchAlgorithmException{
		as.addAccount(input);
		
		return "redirect:/";
	}
	
	//마이페이지
	@GetMapping("/mypage")
	public void mypage() {}

	//회원탈퇴
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable int idx) {
		as.delAccount(idx);
		
		return "redirect:/account/logout";
	}
	
	//회원 정보 수정 폼
	@GetMapping("/update/{idx}")
	public String update(@PathVariable int idx) {
		
		return "account/update";
		
	}
	
	//회원수정 수행
	@PostMapping("/update/{idx}")
	public String update(AccountVO input) 
throws NoSuchAlgorithmException {
		as.upAccount(input);
		
		return "redirect:/account/logout";
	}

	//아이디 찾기 폼
	@GetMapping("/idfind")
	public void idfind() {}

	//아이디 찾기 수행
	@PostMapping("/idfind")
	public ModelAndView idfind(String email) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("data",as.idfind(email)); //여기서는 겹치는 게 없어서 selectOne 사용해도 됨
		mav.addObject("row",1);
		mav.setViewName("message");
		
		return mav;
	}
	
	//비밀번호 찾기 수행
	@PostMapping("/findpw")
	public ModelAndView findPW(AccountVO input) throws LoginException {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("idx", as.findPW(input));
		mav.setViewName("account/newPassword");
		
		return mav;
	
	
	}
	
	//새 패스워드로 변경
	@PostMapping("/newPassword")
	public ModelAndView newPassword(AccountVO input) 
			throws NoSuchAlgorithmException {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row",as.newPassword(input));
		mav.addObject("data","변경이 완료되었습니다.");
		mav.setViewName("message");
		return mav;
	}
}