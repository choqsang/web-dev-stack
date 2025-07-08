<!-- HTML 주석 : 둘 다 사용 가능하지만 소스 코드에 보여짐 -->
<%-- JSP 주석 : 소스 코드에 노출되지 않음 

JSP Element
1. 지시어 %@ % : 컨테이너에게 알려줄 내용 지정
2. 스클릿틀릿 % % : 자바코드는 이 안에 지정
3. 출력문 %= % : 출력하는 내용 지정

--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- check 값도 바인딩 해서 해당 페이지 내에서 조건을 걸 수 있음! (fail.jsp 추가 없이) --%>
	<%--String name = (String) request.getAttribute("name"); --%>
	<% // 가져올 때 형변환 %>
	   <%boolean check = (boolean) request.getAttribute("check"); 
	   	 String name = request.getParameter("name");
	   %>
	   
	   <%
	   if(check){ // check가 true인 경우
		   %><h1>😆<%=name %>님, 회원가입이 완료되었습니다!😆</h1><%
	   } else { // check가 false인 경우
		   %><h1>회원가입 실패 ㅠㅠ</h1><%
	   }%>
		   
</body>
</html>
