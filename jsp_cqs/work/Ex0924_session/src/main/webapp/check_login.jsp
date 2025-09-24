<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 로그인이 필요한 페이지는 해당 페이지를 통해야만 하게끔 세팅 --%>
	<c:if test="${ empty sessionScope.user }" > 
		<script>
			alert("로그인 후 이용하세요");
			location.href="login_form.jsp";
		</script>
	</c:if>
</body>
</html>