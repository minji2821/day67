<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

  <script>
  	let row = ${row};
  	let data = '${data}';
  	
  	if(row!=0){
  		//성공->/로 이동
  		alert(data);
  		location.href = '${cpath}';
  		
  	}
  	else{
  		//실패: -> 뒤 페이지로 이동
  		alert(data);
  		history.go(-1);
  	}
  
  </script>
  
</body>
</html>