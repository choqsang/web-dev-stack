<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/list.css"></link>
</head>
<body>
	<div class="container">
		<div id="header">
		<h1>List Page</h1>
		<div>
		<input type="text" name="search" value="${keyword}">
		<a class="btn btn-dark" href="/view?no=${board.no}">검색</a>
		</div>
		</div>
		
		<table class="table">
			<thead>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>		
				<!-- <th>파일명</th> -->		
				<th>작성시간</th>
				<th>삭제</th>
			</thead>
			<tbody>
				<!-- list 가져와서 표로 만들기! -->
				<c:forEach items="${list}" var="board">
						<tr>
							<td>${board.no}</td>
							<td><a href="/view?no=${board.no}">${board.title}</a></td>
							<td>${board.content}</td>
							<!-- <td>${board.url}</td>  -->
							<td><fmt:formatDate value="${board.formatDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>
							<div class="form-check">
                                <input class="form-check-input delete-checkbox" type="checkbox" value="${board.no}">
                            </div>
								<!-- <div class="form-check">
								<input class="form-check-input" type="checkbox" id="checkDefault" data-no="${item.no}"></div></td>  -->
						</tr>
					</c:forEach>
			</tbody>
		</table><!--
	
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-outline-warning"
			data-bs-toggle="modal" data-bs-target="#writeModal">글 추가</button>
		<button type="button" class="btn btn-outline-danger" id="deletelist">글 삭제</button>
			
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

<script>
	
        $("#deletelist").click((e) => {
            const check = $(e.target).val();
            if (check == null) {
                alert('삭제할 글을 선택해주세요.');
                return;
            }
            if (!confirm('선택된 글을 정말 삭제하시겠습니까?')) {
                return;
            }
        $.ajax({
            type: "post",
            url: "/delete",
            data: "no=" + no,
            success: function (result) {
                if (result && result.success) {
                    alert('글이 성공적으로 삭제되었습니다.');
                    location.reload();
                } else {
                    alert('글 삭제에 실패했습니다: ' + (result ? result.message : '알 수 없는 오류'));
                }
            },
            error: function (xhr, status, error) {
                alert('삭제 중 오류가 발생했습니다: ' + error);
                console.error("AJAX Error: ", status, error, xhr.responseText);
            }
        });
       
      });
</script>

	<nav>
		<ul class="pagination">
			<li class="page-item ${paging.prev ? '' : 'disabled'}"><a
				class="page-link" href="/list?page=${paging.startPage - 1}">Previous</a></li>

			<c:forEach begin="${paging.startPage}" end="${paging.endPage}"
				var="page">
				<li class="page-item"><a
					class="page-link ${paging.page == page ? 'active' : ''}"
					href="/list?page=${page}">${page}</a></li>
			</c:forEach>

			<li class="page-item ${paging.next ? '' : 'disabled'}"><a
				class="page-link" href="/list?page=${paging.endPage + 1}">Next</a></li>
		</ul>
	</nav>

</body>
</html>