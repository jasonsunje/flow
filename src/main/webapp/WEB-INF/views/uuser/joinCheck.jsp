<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - www.codingnepalweb.com -->
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Flow</title>
</head>
<body>
	<div class="container">
		<h1>이용약관 동의</h1>
		<!-- <form id="termsForm"> -->
		<form action="${pageContext.request.contextPath}/uuser/joinform"
			name="check" id="check" method="post">
			<label id="allAgree"> <input type="checkbox" id="checkAll"
				name="selectAll"> 모든 항목 동의
			</label>
			<h4>[필수] 이용약관</h4>
			<div class="terms-box">
				<dl>
					<dt>시행일자:</dt>
					<br>
					<dd>
						Flow 프로젝트<br />
						<br />
					</dd>
				</dl>
			</div>
			<label> <input type="checkbox" id="termService" name="es"
				class="checkVal"> 이용 약관에 동의합니다.
			</label> <br> <input type="button" id="join" value="가입하기"
				disabled="disabled" onclick="javascript:checkJoin()">
		</form>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script>
	const checkAll = document.getElementById('checkAll');
	const es = document.getElementsByName('es');
	const join = document.getElementById('join');
	
	checkAll.addEventListener('click', function(){
		const isChecked = checkAll.checked;
		
		if(isChecked){
			const checkboxes = document.querySelectorAll('.checkVal');
			
			for(const checkbox of checkboxes){
				checkbox.checked = true;
				checkReq();
			}
		}else{
			const checkboxes = document.querySelectorAll('.checkVal');
			
			for(const checkbox of checkboxes){
				checkbox.checked = false;
				checkReq();
			}
		}
	});
	const checkboxes = document.querySelectorAll('.checkVal');
	for(const checkbox of checkboxes){
		checkbox.addEventListener('click', function(){	
			const totalCnt = checkboxes.length;
			const checkedCnt = document.querySelectorAll('.checkVal:checked').length;
			checkReq();
			if(totalCnt == checkedCnt){
				document.querySelector('#checkAll').checked = true;
			}else{
				document.querySelector('#checkAll').checked = false;
			}
		});
	}
	function checkReq(){
		let count = 0;
		es.forEach((obj) => {
			const esLength = es.length;
			if(obj.checked == true){
				count++;
			}
			if(esLength == count){
				join.disabled = false;
			}else{
				join.disabled = true;
			}
			});
		}
	function checkJoin(){
		document.check.submit();
	}
</script>