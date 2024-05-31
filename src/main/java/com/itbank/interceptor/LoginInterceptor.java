package com.itbank.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.itbank.vo.AccountVO;


/*
	Interceptor
	-요청을 가로채서 필요한 처리를 하기 위한 Spring 객체(bean)
	-controller로 넘어가기 전, controller 수행 후, 클라이언트에 전달된 후를 처리 가능
	
	작동시점)
	1. preHandle		요청이 controller로 넘어가기 전에 가로챈다
	2. postHandle		controller 메서드가 수행된 후 가로챈다
	3. aftercompletion	응답이 클라이언트에 전달된 후 수행
*/	

public class LoginInterceptor extends HandlerInterceptorAdapter {

	//prehandle
	//-true를 반환하면 요청한 controller로 이어 진행
	//-false를 반환하면 controller로 전달하지 않고 종료
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//최상위 경로를 설정
		String cpath = request.getContextPath();
		
		// 세션을 가져온다
		HttpSession session = request.getSession();
		
		//세션에서 user(=로그인된 계정)을 가져온다
		AccountVO user = (AccountVO) session.getAttribute("user");
		
		//로그인 상태가 아니면
		if (user == null) {
			response.sendRedirect(cpath + "/account/login");
				
			return false;	//false면 원래 진행하려던 controller를 수행하지 않는다
		
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
