package com.itbank.component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class SHA512Hash {
	public String getHash(String pw) throws NoSuchAlgorithmException {
		//1. 입력 받은 패스워드를 가져와서
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		
		md.reset();
		md.update(pw.getBytes());
		
		//2. 해시코드로 변환 후
		String hashpw = String.format("%0128x",new BigInteger(1, md.digest()));
		
		//3. 반환		
		return hashpw;
	}
	

}
