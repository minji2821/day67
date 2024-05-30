package com.itbank.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice		//예외를 받아 처리할 스프링 객체
public class AccountAdvice {
	
	@ExceptionHandler(LoginException.class) //처리할 예외 클래스를 명시
	public ModelAndView failLogin(LoginException e) {
		//1. 예외 정보를 활용하려면 매개변수에 변수를 작성하면 되고
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row",0);
		mav.addObject("data",e.getMessage());
		mav.setViewName("message");
		
		return mav;
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	public ModelAndView failSignUp() {
		//2. 딱히 필요없으면 생략 가능
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row",0);
		mav.addObject("data","이미 가입된 정보입니다");
		mav.setViewName("message");
		
		return mav;
	}
}
