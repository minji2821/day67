package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.exception.LoginException;
import com.itbank.model.AccountDAO;
import com.itbank.vo.AccountVO;

@Service
public class AccountService {

	@Autowired
	private AccountDAO dao;
	
	public List<AccountVO> getAccounts() {
		return dao.selectAll();
	}

	public AccountVO login(AccountVO input) 
		throws LoginException {
			
		
		input = dao.selectOne(input);
		
		//login fail
		if(input == null) {
			String msg="존재하지 않는 정보입니다";
			//throw로 예외를 강제로 발생시킨다
			throw new LoginException(msg);
		}
		return input;
	}
	
	public int addAccount(AccountVO input) {
		return dao.insert(input);
	}
}
