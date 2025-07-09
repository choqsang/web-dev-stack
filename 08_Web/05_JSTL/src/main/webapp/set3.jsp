<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- taglib은 거의 위와 동일하게 세팅함! -->
<%--
	JSTL (JSP Standard Tag Library) : JSP에서 사용되는 태그 형식의 표준 라이브러리
	1. 라이브러리 추가(jar)
	2. taglib 속성 지정
 --%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- c:set 변수 지정 -->
	<c:set var="num1" value="5" scope="request"/>
	<c:set var="num2" value="9" />
	<c:set var="multiple" value="${num1 * num2}" />
	<h4>${num1} * ${num2} = ${num1 * num2} / 곱셈식의 값은 ${multiple}</h4>
	
</body>
</html>