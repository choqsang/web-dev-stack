<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script>
		</script>
		
	</head>
	
	<body>
		<jsp:include page="index.jsp" />
		
		<table border="1" align="center" width="600">
			<tr bgcolor="#dedede">
				<th>제품코드</th>
				<th>미리보기</th>
				<th width="20%">제품명</th>				
				<th width="25%">가격</th>				
				<th>수량</th>				
				<th colspan="2">금액</th>	
			</tr>
			<c:forEach var="vo" items="${list}">
			<tr align="center">
				<td>${vo.p_num}</td>
				<td><img src="images/${vo.p_image_s}" width="100"/></td>
				<td><span onClick="location.href='view.do?idx=${vo.idx}'">
				${vo.p_name}</span></td>
				<td>
				<font style="text-decoration: line-through;">
				단가 : <fmt:formatNumber value="${vo.p_price}"/>원</font>
				<br>
				<font color="red">
				세일가 : <b><fmt:formatNumber value="${vo.p_saleprice}"/>원</b>
				</font></td>
				<td>
					<form>
						<input type="hidden" value="${vo.idx}">
						<input size="3" value="${vo.c_cnt}"><br>
						<input type="submit" value="수정" onClick="">
					</form>
				</td>
				<td><fmt:formatNumber value="${vo.amount}"/>원</td>
				<td><input type="button" value="삭제"></td>
				</c:forEach>
			</tr>
			<tr>
				<td colspan="6" align="right">
					총 결제 금액 &nbsp;
					<!-- &nbsp; 강제로 공백을 줌 -->
				</td>
				<td align="center"><fmt:formatNumber value="${total}"/></td>
			</tr>
			
		</table>
		
	</body>
</html>