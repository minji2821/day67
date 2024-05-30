package com.itbank.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.SHA512Hash;
import com.itbank.exception.LoginException;
import com.itbank.model.AccountDAO;
import com.itbank.vo.AccountVO;



@Service
public class AccountService {

	@Autowired
	private AccountDAO dao;
	
	@Autowired
	private SHA512Hash  hash;
	
	public List<AccountVO> getAccounts() {
		return dao.selectAll();
	}

	public AccountVO login(AccountVO input) 
		throws LoginException, NoSuchAlgorithmException {
		// 여기 해시 pw를 적용해서 해시 처리된 계정이 로그인 되게 한다
		// 그 후, 일반 pw 계정은 로그인 안 됨
		
		String userpw = input.getUserpw();
		String hashpw = hash.getHash(userpw);

		input.setUserpw(hashpw);
		
		input = dao.selectOne(input);
		
		//로그인 실패
		if(input == null) {
			String msg="존재하지 않는 정보입니다";
			
			//throw로 예외를 강제로 발생시킨다
			throw new LoginException(msg);
		}
		return input;
	}
	
	public int addAccount(AccountVO input) 
			throws NoSuchAlgorithmException {
		//DB에 넘기기전에 해서 처리할 거임(=상세로직)
		

		//3. vo의 userpw에 덮어쓴다
		String userpw = input.getUserpw();
		String hashpw = hash.getHash(userpw);

		input.setUserpw(hashpw);
		
		//4. 그 후 DAO에 전달
		return dao.insert(input);
	}
	
	
	
	


}
