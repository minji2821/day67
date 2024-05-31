<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h4>새 패스워드 입력</h4>
<form action = "newPassword" method="post">
  <p><input name="userpw" type="password" placeholder="새 패스워드"></p>
  <p><input name="check" type="password" placeholder="패스워드 확인"></p>
  
  <input name="idx" type="hidden" value="${idx }">
  <button>변경</button>
  </form>
  
  <script>
  // input 태그를 모두 찾아온다(3개)
  	let inputs = document.querySelectorAll('input');
  	
  // 2번째 <input>에서 커서가 빠지면 아래 코드를 수행
  	inputs[1].onblur = () => {
  		
  		// 0, 1번의 input의 작성된 값을 가져온다
  		let userpw = inputs[0].value;
  		let check = inputs[1].value;
  		
  		//가져온 두 값을 비교 후 일치하지 않으면
  		if (userpw !== check) {
  			//메시지 출력 후
  			alert('패스워드가 일치하지 않습니다');
  			
  			//두 값을 모두 지우고
  			inputs[0].value = '';
  			inputs[1].value = '';
			
  			//0번 <input>으로 커서를 이동시킨다
  			inputs[0].focus();
  		}
  		//일치하면 그냥 다음으로 진행
  	}

  </script>
</body>
</html>