<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>파일 업로드</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>List Page</h1>
		<table class="table">
			<thead>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>		
				<th>파일명</th>		
				<th>작성시간</th>
				<th>삭제</th>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
						<tr>
							<td>${item.no}</td>
							<td>${item.title}</td>
							<td>${item.content}</td>
							<td>${item.url}</td>
							<td>${item.createdAt}</td>
							<td><div class="form-check">
							<input class="form-check-input" type="checkbox" id="checkDefault" data-no="${item.no}"></div></td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	<script>
	$("#deletelist").click((e) => {
        const no = $(e.target).data('no');
        //console.log(no);
        $.ajax({
            // 요청
            type: "post",
            url: "/delete",
            data: "no=" + no,
            // 응답
            success: function (result) {
				location.reload();
            },
          });
      });
	</script>

		<!-- Button trigger modal -->
		<button type="button" class="btn btn-outline-warning"
			data-bs-toggle="modal" data-bs-target="#writeModal">글 추가</button>
		<button type="button" class="btn btn-danger" id="deletelist">글 삭제</button>

		<!-- Modal -->
		<div class="modal fade" id="writeModal" tabindex="-1"
			aria-labelledby="writeModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="writeModalLabel">게시글 등록</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<form action="/write" method="post" enctype="multipart/form-data">
						<div class="modal-body">
							<div class="mb-3">
								<label class="form-label">Title</label>
								<input type="text" class="form-control" name="title">
							</div>
							<div class="mb-3">
								<label class="form-label">Content</label>
								<textarea class="form-control" rows="3" name="content"></textarea>
							</div>
							<div class="mb-3">
								<label class="form-label">Add File</label> <input
									class="form-control" name="file" type="file" accept="image/*">
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-warning">등록</button>
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">닫기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>