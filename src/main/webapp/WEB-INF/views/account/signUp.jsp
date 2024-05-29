<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
  
  <div>
    <form method="POST">
      <p><input name="userid" placeholder="ID" required></p>
      <p><input name="userpw" placeholder="PW" type="password" required></p>
      <p><input name="nick" placeholder="nick" required></p>
      <p><input name="email" placeholder="email" type="email" required></p>
      
      <button>SignUp</button>
    </form>
  </div>
 
</body>
</html>