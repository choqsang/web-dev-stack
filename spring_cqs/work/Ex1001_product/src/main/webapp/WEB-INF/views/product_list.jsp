<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Insert title here</title>
		
		<script>
			function update(f){
				f.action = "product_update?idx=" f.idx.value;
				f.submit();
			}
		</script>
		
	</head>
	
	<body>
		<jsp:include page="index.jsp" />
	
		<div align="center" width="600">
			<input type="button" value="상품등록"
				   onclick="location.href='product_regi_form.jsp'" />
		</div>
		
		<table align="center"
			   width="600"
			   border="1"
			   style="border-collapse:collapse;">
			<tr bgcolor="#dedede">
				<th width="12%">제품코드</th>
				<th width="12%">이미지</th>
				<th width="50%">제품명</th>
				<th>가격</th>
			</tr>
			
			<c:forEach var="vo" items="${ list }">
				<tr align="center">
					<td>${ vo.p_num }</td>
					<td>
						<img src="product/resources/images/${vo.p_image_s}" width="100" height="90" />
					</td>
					<td>
						<a href="view.do?idx=${vo.idx}">${ vo.p_name }</a>
					</td>
					<td>
						<del><fmt:formatNumber value="${ vo.p_price }" /></del> <br>
						<fmt:formatNumber value="${ vo.p_saleprice }" />원<br>
						<font color="red">( ${ vo.sale_rate }% )</font><br>
						<input type="button" value="수정" />
					</td>
				</tr>
			</c:forEach>
			
		</table>
		
	</body>
</html>