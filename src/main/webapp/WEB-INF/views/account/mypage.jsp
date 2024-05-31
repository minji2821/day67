<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h1>마이페이지</h1>

<table>
  <tr>
  <th>회원번호</th>
  <td> ${user.idx}번 </td>
  </tr>
  <tr>
  <th>아이디</th>
   <td>${user.userid}</td>
  </tr>
  <tr>
  <th>닉네임</th>
   <td>${user.nick}</td>
  </tr>
  <tr>
  <th>이메일</th>
   <td>${user.email}</td>
  </tr>
  <tr>
  <th>가입일</th>
   <td>${user.join_date}</td>
  </tr>
</table>
  
  <br>
  <button>수정</button>

  <button>탈퇴</button>

<script>
 let btns = document.querySelectorAll('button');
 
 //수정버튼
 btns[0].onclick = ()=>{
	 location.href = '${cpath}/account/update/${user.idx}';
 };
 //삭제버튼
  btns[1].onclick = () => {
	  location.href = '${cpath}/account/delete/${user.idx}';
  };
</script>
  
</body>
</html>