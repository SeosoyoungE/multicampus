<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

	<script type="text/javascript">
		//아이디체크하기 - 4글자 이상 , java면 이미 사용중인 아이디 아니면 사용가능아이디
		//출력하기 - jQuery로 변경하기
		$(document).ready(function(){
			$("#id").on("keyup",function(){
				if($("#id").val().length<4){
					$("#result").text("4글자 이상의 아이디를 입력하세요");
					$("#result").attr("style","color:red");
				} else if($("#id").val()=="java"){
					$("#result").text("이미 사용중인 아이디입니다.");
					$("#result").attr("style","color:red");
				} else{
					/* $("#result").text(""); */
					$("#result").text("사용 가능한 아이디입니다.");
					$("#result").attr("style","color:blue");
				}
			});
		})
	</script>
</head>
<body>
	<h1>티몬 회원가입</h1>
	<h2>필수항목</h2>
	<form name="myform">
		아이디:<input type="text" id="id" />
	</form>
	<div id="result" style="color: red;"></div>
</body>
</html>