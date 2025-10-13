<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script>
			function send(f){
				f.action = "insert.do";
				f.submit();
			}
		</script>
		
	</head>
	
	<body>
		<jsp:include page="../index.jsp" />
		
		<form method="post"
			  enctype="multipart/form-data">
		
			<table border="1"
				   align="center"
				   width="600">
				   
				<tr>
					<td>제품 카테고리</td>
					<td>
						<select name="category">
							<option>카테고리 선택</option>
							<option value="com001">컴퓨터</option>
							<option value="ele002">생활가전</option>
							<option value="sp003">스포츠</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>제품코드</td>
					<td>
						<input name="p_num" />
					</td>
				</tr>
				
				<tr>
					<td>제품명</td>
					<td>
						<input name="p_name" />
					</td>
				</tr>
				
				<tr>
					<td>제조사</td>
					<td>
						<input name="p_company" />
					</td>
				</tr>
				
				<tr>
					<td>제품가격</td>
					<td>
						<input name="p_price" />
					</td>
				</tr>
				
				<tr>
					<td>할인가격</td>
					<td>
						<input name="p_saleprice" />
					</td>
				</tr>
				
				<tr>
					<td colspan="2">제품설명</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<textarea rows="5" cols="80" style="resize:none"
								  name="p_content"></textarea>
					</td>
				</tr>
				
				<tr>
					<td>작은사진(썸네일)</td>
					<td>
						<input type="file" name="photo1" />
					</td>
				</tr>
				
				<tr>
					<td>큰 사진(상세보기)</td>
					<td>
						<input type="file" name="photo2" />
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="button" value="등록"
							   onclick="send(this.form)" />
						<input type="button" value="취소"
								  onclick="history.back()" />
					</td>
				</tr>
				
			</table>
		
		</form>
	</body>
</html>