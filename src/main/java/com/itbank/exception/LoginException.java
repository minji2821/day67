package com.itbank.exception;

//예외 클래스로 만들어 사용하려면 exception을 상속 받아야한다
public class LoginException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public LoginException(String msg) {
		super(msg);		//부모 생성자 호출
						//즉, Exception(msg)에 전달
	}
}
