<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script src="js/httpRequest.js"></script>
		
		<script>
			function m_send(f) {
				
				let url = "list.do";
				let param = "search_txt=" + f.search_txt.value; // 도서명 검색
				sendRequest(url, param, resultFn, "get"); // ajax 요청 > 콜백 함수로 응답
				
			}
			
			function resultFn() {
				
				if(xhr.readyState == 4 && xhr.status == 200){
					
					let data = xhr.responseText;
					let json = eval(data);
					
					// JSON으로 받아온 도서목록을 테이블에 출력하기 위해 생성
					let resTable = document.getElementById("resTable");
					resTable.innerHTML = "";
					
					// 가져온 도서 수만큼 반복하여 <tr> 생성
					json[0].items.forEach(item => {
						let row = document.createElement("tr");
						// 각 행은 이미지와 제목 / 저자 / 가격 으로 구성하여 추가
						row.innerHTML = 
							"<td><img src='" + item.image + "' width='100' /></td>" +
							"<td><span>" + item.title + "</span>" + 
							"<br>저자: " + item.aothor + 
							"<br>가격: " + item.discount +  
							"</td>"
							
							resTable.appendChild(row);
							
					});
					
				}
				
			}
		</script>
		<link rel="stylesheet" href="css/book.css"/>
		
	</head>
	
	<body>
		<form align="center">
			<div>
			<input id="search_bar" name="search_txt" />
			<input id="search_btn" type="button" value="검색"
				   onclick="m_send(this.form)" />
			</div>
			<table id="resTable" border="1" align="center"></table>
		</form>
	</body>
</html>