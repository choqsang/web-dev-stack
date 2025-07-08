<%@page import="vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.MemberDAO"%>
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
	
	<h2><u><%=id %></u> 회원 검색 결과</h2>
	<% if(member!=null) {%>
	<ul>
	<li>아이디 : <%=member.getId() %></li>	
	<li>이름 : <%=member.getName() %></li>	
	<li>나이 : <%=member.getAge() %></li>	
	</ul>
									
	<% } else { %>
		<h2 style="color:red;">아이디가 '<%=id %>'인 회원 정보가 없습니다!</h2>
	<% } %>
</body>
</html>