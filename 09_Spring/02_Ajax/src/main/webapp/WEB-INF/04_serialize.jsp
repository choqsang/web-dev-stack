<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>serialize</title>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
    <h1>회원가입</h1>
    <form id="frm">
    	아이디 : <input type="text" name="id" id="id" /><br>
    	이름 : <input type="text" name="name" id="name" /><br>
    	비밀번호 : <input type="password" name="pwd" id="pwd" /><br>
    	나이 : <input type="text" name="age" /><br>
    <input type="button" id="btn" value="회원가입" /><br>
    </form>
    <div id="result"></div>
    
    <script>
    $("#btn").click(() => {
        $.ajax({
          type: "post",
          url: "/register",
          data: $("#frm").serialize(), // form값을 그대로 받아온다. 
       	  // "id=" + $("#id").val() + "&pwd=" + $("#pwd").val() + "&name=" + $("#name").val(),
          success: function (result) {
				// console.log(result.name);
				$("#result").text(result.name + "님이 회원가입 하셨습니다!")
          },
        });
      });
    
    </script>
  </body>
</html>
