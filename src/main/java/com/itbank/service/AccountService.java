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
	
	//모든 회원 정보 가져오기
	public List<AccountVO> getAccounts() {
		return dao.selectAll();
	}
	
	//로그인
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
	
	//회원가입
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
	
	//회원탈퇴
	public int delAccount(int idx) {
		return dao.delete(idx);
	}
	
	//회원수정
	public int upAccount(AccountVO input) throws NoSuchAlgorithmException {
		String userpw = input.getUserpw();
		String hashpw = hash.getHash(userpw);
		
		input.setUserpw(hashpw);
		
		return dao.update(input);
	}
	//아이디 찾기
	public String idfind(String email) {
		return dao.selectEmail(email);
	}
	
	//비밀번호 찾기
	public int findPW(AccountVO input) throws LoginException {
		//dao에 userid, email을 보내서
		//일치하는 계정이 있으면 새 패스워드 입력 창
		//없으면 예외를 발생
		input = dao.selectFind(input);
		
		//없으면 예외를 발생
		if ( input == null) {
			String msg = "일치하는 정보가 존재하지 않습니다";
			
			throw new LoginException(msg);
		}
		return input.getIdx();
	}

	//새 패스워드로 변경
	public int newPassword(AccountVO input)
			throws NoSuchAlgorithmException {
		
		String userpw = input.getUserpw();
		String hashpw = hash.getHash(userpw);
		
		input.setUserpw(hashpw);
		
		
		return dao.updateNewPW(input);
	}
}
