<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. 기존 방식</h2>
	<%
		String id = (String) request.getParameter("id");
		String[] hobbyList = (String[]) request.getParameterValues("hobby");
	%>
	<ul>
	<li>아이디 : <%=id %></li>
	<% for(String hobby : hobbyList) { %>
		<li>취미 : <%=hobby %></li>
	<% } %>
	</ul>
	
	<h2>2. EL</h2>
	<ul>
	<li>아이디 : ${param.id}</li>
	<li>취미 : ${paramValues.hobby[0]}</li> <%-- 반복문 등은 대체할 수 없음 --%>
	</ul>
</body>
</html>