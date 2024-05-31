<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
  <h4> 아이디 찾기 </h4>
  
  
  <form action="idfind" method="post">
    <p><input name="email" type="email" placeholder="아이디찾기" required></p>

  <button>찾기</button>    
  
  </form>
  
  
 <!--  비밀번호 찾기-->
   <h4> 비밀번호 찾기 </h4>
  
  <form action="findpw" method="post">
    <p><input name="userid" placeholder="가입 시  ID" required></p>
    <p><input name="email" type="email" placeholder="가입시 이메일" required></p>

  <button>찾기</button>    
  
  </form>
</body>
</html>