<%@page import="vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 전체 회원 보기 : AllMemberServlet 
						views/allMember.jsp에 리스트 출력 --%>
						
	<h1>전체 회원 보기</h1>
	<% 
	ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");%>
	<table border="1">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>나이</th>
	</tr>
	<% for(Member member : list) { %>
		<tr>
			<td><%=member.getId() %></td>
			<td><%=member.getName() %></td>
			<td><%=member.getPwd() %></td>
			<td><%=member.getAge() %></td>
		<tr>
	<% } %>
	</table>	   					
</body>
</html>