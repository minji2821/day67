package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.vo.BoardVO;

public interface BoardDAO {
	
	@Select("select banner from v$version") //oracle -> service -> cotroller ->$ 출력 
	String test();
	
	
	List<BoardVO> selectAll();
	
}
