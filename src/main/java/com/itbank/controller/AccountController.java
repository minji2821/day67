package com.itbank.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.exception.LoginException;
import com.itbank.service.AccountService;
import com.itbank.vo.AccountVO;


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
	
	@GetMapping("/mypage")
	public String mypage(HttpSession session) {
		AccountVO user=(AccountVO) session.getAttribute("user");
		
		if(user==null) {
			return "redirect:/account/login";
		}
		return "account/mypage";
	}
}
