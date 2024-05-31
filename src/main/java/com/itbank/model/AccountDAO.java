package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.itbank.vo.AccountVO;

public interface AccountDAO {

	List<AccountVO> selectAll();
	
	AccountVO selectOne(AccountVO input);
	
	int insert(AccountVO input);
	
	int update(AccountVO input);
	
	AccountVO selectFind(AccountVO input);
	
	int updateNewPW(AccountVO input);
	
	@Delete("delete from account where idx = #{idx}")
	int delete(int idx);

	@Select("select userid from account where email = #{email}")
	String selectEmail(String email);




}
