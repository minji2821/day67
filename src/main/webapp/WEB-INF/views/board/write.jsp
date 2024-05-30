<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="post">
  <table>
    <tr>
      <td><input name="title" placeholder="제목" required></td>
    </tr>
    <tr>
      <td><textarea name="contents" placeholder="내용" required></textarea></td>
    </tr>
  </table>
  
  <br>
  
  <input name="a_idx" type="hidden" value="${user.idx }">
  
  <button>작성</button>
</form>

</body>
</html>