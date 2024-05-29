package com.itbank.model;

import java.util.List;

import com.itbank.vo.AccountVO;

public interface AccountDAO {

	List<AccountVO> selectAll();
	
	AccountVO selectOne(AccountVO input);
	
	int insert(AccountVO input);

}
