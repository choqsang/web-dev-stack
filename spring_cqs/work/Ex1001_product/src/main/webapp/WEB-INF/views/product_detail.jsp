<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

		<script src="js/httpRequest.js"></script>
		<script>
			function addCart(idx, m_idx){
				
				let url = "cart_insert.do";
				let param = "idx=" + idx + "&m_idx=" + m_idx;
				
				sendRequest( url, param, resultAdd, "post");
			}
			
			function resultAdd(){
				if(xhr.readyState == 4 && xhr.status == 200){
					// "[{'result':'yes'}]"
					let data = xhr.responseText;
					let json = eval(data);
					
					if ( json[0].result == "yes" ){
						alert("장바구니에 담았습니다");
						if( confirm("장바구니로 이동하시겠습니까?") ){
							location.href="cart_list.do?m_idx=1";
						}
					} else {
						alert("이미 장바구니에 담겨있는 상품입니다")
					}
				}
			}
			
		</script>		

</head>

<body>
	<jsp:include page="index.jsp" />
	<form method="post" enctype="multipart/form-data">

		<table border="1" align="center" width="600">

			<tr>
				<td>카테고리</td>
				<td>${ vo.category }</td>
			</tr>

			<tr>
				<td>제품코드</td>
				<td>${ vo.p_num }</td>
			</tr>

			<tr>
				<td>제품명</td>
				<td>${ vo.p_name }</td>
			</tr>

			<tr>
				<td>제조사</td>
				<td>${ vo.p_company }</td>
			</tr>

			<tr>
				<td>제품가격</td>
				<td><fmt:formatNumber value="${ vo.p_price }" />원
				( 할인가 : <fmt:formatNumber value="${ vo.p_saleprice }" /> 원 )</td>
			</tr>

			<tr>
				<td>제품설명</td>
				<td><pre>${ vo.p_content }</pre></td>
				<!-- pre 태그 안에서는 DB에서 인식되지 않는 줄 바꿈이 입력값 그대로 출력된다 -->
			</tr>

			<tr>
				<td colspan="2" align="center"><img src="images/${vo.p_image_l}" width="400"/></td>
			</tr>


			<tr>
				<td colspan="2">
				<input type="button" value="장바구니 담기" onClick="addCart('${vo.idx}', '1' )"/>
				<!-- 장바구니 담을 상품 번호와 로그인 되어 있는 회원 번호 넘김 -->
				 
				<input type="button" value="장바구니 보기" onClick="location.href='cart_list.do?m_idx=1'"/> 
				<input
					type="button" value="뒤로" onclick="history.back()" /></td>
			</tr>

		</table>

	</form>
</body>
</html>