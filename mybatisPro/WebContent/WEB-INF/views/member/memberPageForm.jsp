<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#updateForm input[type=text], #updateForm input[type=password], #insertForm input[type=email]{
		width:200px;
		margin:5px;
	}
	#updateForm tr>td:nth-child(1){text-align:right;}
</style>
</head>
<body>
	
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer">
		<br>
		<h1 align="center">정보수정</h1>
		<br>
		
		<form id="updateForm" action="update.me" method="post">
			<table align="center">
				<tr>
					<td>* ID : </td>
					<td><input type="text" name="userId" value="${sessionScope.loginUser.userId}" disabled required></td>
				</tr>
				<tr>
					<td>* PWD : </td>
					<td><input type="password" name="userPwd" value="${loginUser.userPwd}" disabled  required></td>
				</tr>
				<tr>
					<td>* NAME : </td>
					<td><input type="text" name="userName" value="${loginUser.userName}"  disabled required></td>
				</tr>
				<tr>
					<td>EMAIL : </td>
					<td><input type="email" name="email" value="${loginUser.email}" ></td>
				</tr>
				<tr>
					<td>BIRTHDAY : </td>
					<td><input type="text" name="birthday" value="${loginUser.birthday}"></td>
				</tr>
				<tr>
					<td>GENDER : </td>
					<td>
						<input type="radio" name="gender" id="M" value="M"> 남 
						<input type="radio" name="gender" id="F" value="F"> 여 
					</td>
				</tr>
				<tr>
					<td>PHONE : </td>
					<td><input type="text" name="phone" value="${sessionScope.loginUser.phone}"></td>
				</tr>
				<tr>
					<td>ADDRESS : </td>
					<td><input type="text" name="address" value="${sessionScope.loginUser.address}"></td>
				</tr>
			</table>
			
			<br>
			<div class="btns" align="center">
				<button type="delete">회원탈퇴</button>
				<button type="submit">정보수정</button>
			</div>
		</form>
		<br><br>
	</div>
	
	<script>
	
	$("button[type=delete]").on("click",function(){
		location.href='delete.me';
	})
	
	
 	$(function(){
		
		var gen = '${loginUser.gender}';
		if(gen == 'M'){
			$("#M").attr("checked",true)
		}else{
			$("#F").attr("checked",true)

		}
		
	}) 
	</script>

</body>
</html>