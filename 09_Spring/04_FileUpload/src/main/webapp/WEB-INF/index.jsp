<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파일 업로드</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<!-- <style>
  /* --- CSS 시작 --- */
  body {
    font-family: Arial, sans-serif;
    margin: 20px;
    background-color: #f4f4f4;
    color: #333;
  }

  h2 {
    color: #333;
    border-bottom: 2px solid #ccc;
    padding-bottom: 10px;
    margin-bottom: 20px;
  }

  form {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin-bottom: 30px;
  }

  input[type="file"] {
    display: block;
    margin-bottom: 15px;
    border: 1px solid #ddd;
    padding: 10px;
    border-radius: 4px;
    width: calc(100% - 22px); /* 패딩과 보더 고려 */
  }

  input[type="submit"] {
    background-color: #007bff;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
  }

  input[type="submit"]:hover {
    background-color: #0056b3;
  }

  #imagePreviewContainer {
    margin-top: 20px;
    border: 1px dashed #ccc;
    padding: 15px;
    border-radius: 8px;
    background-color: #e9e9e9;
    min-height: 100px; /* 미리보기 영역 최소 높이 */
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
    color: #666;
  }

  #imagePreview {
    max-width: 100%; /* 컨테이너를 넘지 않도록 최대 너비 설정 */
    max-height: 300px; /* 이미지 미리보기 최대 높이 설정 */
    display: none; /* 초기에는 숨김 */
    border-radius: 4px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
  }
  /* --- CSS 끝 --- */
</style> -->
</head>
<body>
	
	<!-- list.jsp -->
	<a href="list">게시판 글 목록</a>
	
	<h2>File Upload Test</h2>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		<input type="submit" value="파일 업로드">
	</form>
	
	<h2>Multi File Upload Test</h2>
	<form action="/multiUpload" method="post" enctype="multipart/form-data">
		<input type="file" name="files" multiple accept="image/*"><br>
		<input type="submit" value="파일 업로드" />
	</form>
	
	<h2>File 정보 등록</h2>
	<form action="/insert" method="post" enctype="multipart/form-data">
		<input type="file" name="file"><br>
		<input type="submit" value="파일 등록">
	</form>
	
	<button id="open">모달 열기</button>
	<div class="modal-bg">
		<div class="modal">
			<button id="close">X</button>
			<h3>파일 업로드</h3>
			<form action="/upload" method="post" enctype="multipart/form-data">
				<input type="file" name="file"><br>
				<input type="submit" value="파일 업로드">
			</form>
		</div>
	</div>
	
	<style>
		.modal-bg {
			position: fixed;
			top: 0; left: 0; right: 0; bottom: 0;
			background: #3337;
			z-index: 1000;
			display: none;
			justify-content: center;
			align-items: center;
		}
		.modal {
			background: white;
			position: relative;
			width: 350px;
			padding: 20px;
		}
		.modal #close {
			position: absolute;
			top: 10px; right: 10px;
			cursor: pointer;
			font-size: 15px;
			border: none;
			background: none;
		}
	</style>
	<script>
	$("#open").click(() => {
         $(".modal-bg").css("display", "flex");       
      });
	
	$("#close").click(() => {
        $(".modal-bg").css("display", "none");       
     });
	
	$(".modal-bg").click((e) => {
        if(e.target === e.currentTarget) {
			$(".modal-bg").css("display", "none");
        }
     });
	</script>

</body>
</html>
