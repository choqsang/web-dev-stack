<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Member member = (Member) request.getAttribute("member");
		String id = request.getParameter("id");%>
	
	<h2><u><i><%=id %></i></u> 회원 검색</h2>
	<% if(member!=null) {%>
	<ul>
	<li>아이디 : <%=member.getId() %></li>	
	<li>이름 : <%=member.getName() %></li>	
	<li>나이 : <%=member.getAge() %></li>	
	</ul>
	<a href="/">메인 페이지로 이동</a>
										
	<% } else { %>
		<h3>'<%=id %>' 회원 검색에 실패했습니다!</h3>
	<% } %>	
</body>
</html>