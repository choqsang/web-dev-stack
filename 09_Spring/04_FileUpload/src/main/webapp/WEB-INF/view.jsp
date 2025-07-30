<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
	<style>
		#header {
		display: flex;
	    flex-wrap: nowrap;
	    justify-content: space-between;
	    font-weight: bold;
	    
		}
		#header a {
		font-size: 1.5rem;
		padding-right: 50px;
		}
	</style>
</head>
<body>
	<div class="container">
	<!-- a 링크를 통해 딱 해당 정보만 나올 수 있도록 상세보기 페이지 -->
	<div id="header">
	<h1>게시물 정보</h1><a href="/list">리스트로</a>
	</div>
	<form action="/update2" method="post" enctype="multipart/form-data">
		<input type="hidden" name="no" value="${board.no}">
		<input type="hidden" name="url" value="${board.url}">
		<div class="form-group">
			<label>Title</label>
			<input class="form-control" name="title" value="${board.title}">
		</div>
		<div class="form-group">
			<label>Content</label>
			<textarea class="form-control" name="content">${board.content}</textarea>
		</div>
		<!-- 
			수정 시 file이 있다면 기존 파일은 삭제하고 새로 추가된 파일로 업로드하고 DB 수정
			(파일 삭제 : File 객체의 delete() 메서드 사용) 
		 -->
		<img src="http://192.168.0.35:8081/${board.url}" width="500px"/>
		<div class="form-group">
			<label>Update File</label>
			<input class="form-control" name="file" type="file" accept="image/*">
		</div>
		<button id="updateFile" type="submit" class="btn btn-outline-warning">수정</button>
		<a class="btn btn-outline-danger" href="/delete?no=${board.no}">삭제</a>
	</form>
	</div>
	
<!-- <h1>Details</h1>
		<table class="table">
		<thead>
			<th>제목</th>
			<th>내용</th>
			<th>파일명</th>
			<th>작성시간</th>
			<th>이미지</th>
		</thead>
		<tbody>
				<tr>
					<td>${board.title}</td>
					<td>${board.content}</td>
					<td>${board.url}</td>
					<td>${board.createdAt}</td>
					<td><img src="http://192.168.0.35:8081/${board.url}" /></td>
				</tr>
		</tbody>
	</table>  
	<button type="button" class="btn btn-warning"
			data-bs-toggle="modal" data-bs-target="#updateModal">수정</button> -->
		<!-- Modal
		<div class="modal fade" id="updateModal" tabindex="-1"
			aria-labelledby="updateModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="updateModalLabel">게시글 수정</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<form action="/update" method="post" enctype="multipart/form-data">
						<input type="hidden" name="no" value="${board.no}">
						<div class="modal-body">
							<div class="mb-3">
								<label class="form-label">제목</label>
								<input type="text" class="form-control" name="title">
							</div>
							<div class="mb-3">
								<label class="form-label">내용</label>
								<textarea class="form-control" rows="1" name="content"></textarea>
							</div>
							<div class="mb-3">
								<label class="form-label">파일명</label>
								<input type="text" class="form-control" name="url">
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">수정</button>
							<button type="button" class="btn btn-dark"
								data-bs-dismiss="modal">닫기</button>
						</div>
					</form>
				</div>
			</div>
		</div>  
	</div> -->
		
</body>
</html>