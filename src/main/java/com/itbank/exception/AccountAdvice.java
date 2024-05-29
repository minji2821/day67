package com.itbank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice		//예외를 받아 처리할 스프링 객체
public class AccountAdvice {
	
	@ExceptionHandler(LoginException.class) //처리할 예외 클래스를 명시
	public ModelAndView failLogin(LoginException e) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row",0);
		mav.addObject("data",e.getMessage());
		mav.setViewName("message");
		
		return mav;
	}
	

}
