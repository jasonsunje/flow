 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<!-- Coding By CodingNepal - www.codingnepalweb.com -->
<html lang="ko">

<script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Flow</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/join.css">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/fav.png" type="image/png" sizes="16x16"> 
  </head>
  <body>
    <section class="container">
      <header>회원가입</header>
      <form action="${pageContext.request.contextPath}/uuser/join" name="join" id="form" class="form">
        <div class="column">
          <div class="input-box">
            <label>이름</label>
            <input type="id" name="uuserId" autocomplete="off"
            id="uuserId" tabindex="1" placeholder="이름 입력해 주세요." required />
            <br><span id="check"></span>
          </div>
          <div class="input-box">
          <label>&nbsp;</label>
            <input type="button" value="중복확인" id="duplicateBtn" onclick="checkId(this.form)">
          </div>
        </div>        
        <div class="column">
          <div class="input-box">
            <label>비밀번호</label>
            <input type="password" placeholder="비밀번호를 입력해 주세요." required name="uuserPassword" id="uuserPassword" tabindex="2" />
            <br><span id="pwError"></span>
          </div>

          <div class="input-box">
            <label>비밀번호 확인</label>
            <input type="password" placeholder="비밀번호를 재입력해 주세요." required name="repw" id="repw" tabindex="3"/>
            <br><span id="repwError"></span>
          </div>
        </div>
       	 	<button id="join" value="Join" disabled="disabled"
				onclick="javascript:checkJoin()">가입하기</button>
       		<!--  <button  onclick="document.join.reset()" tabindex="12" id="reset">Reset</button> -->
      </form>
    </section>
  </body>
</html>
<script>

	const idTag = document.getElementById('uuserId');
	const pwTag = document.getElementById('uuserPassword');
	
	function checkJoin() {
		if (document.join.uuserId.value == "") {
			alert("비밀번호를 입력하십시오!");
		} else if (document.join.repw.value == "") {
			alert("비밀번호확인을 입력하십시오!");
		} else if (document.join.uuserPassword.value != document.join.repw.value) {
			alert("비밀번호가 일치하지 않습니다.");
		} else {
			document.join.submit();
		}
	}
	

	// 아이디
    
	function checkId(f) {
		if (f.uuserId.value == "") {
			alert("아이디를 입력하십시오!");
			return;
		}
    
		var url = "${pageContext.request.contextPath}/uuser/checkId";
		var param = "id=" + encodeURIComponent(f.uuserId.value);
    
		sendRequest(url, param, resultFn, "POST");
	}
    
	
	function resultFn() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			//도착된 데이터를 읽어오기
			var data = xhr.responseText;
			const join = document.getElementById("join");
			const check = document.getElementById('check');
			const id = document.getElementById('uuserId');
    
			check.innerText = '';
    
			if (data === '사용 가능한 ID입니다') {
				check.style.cssText = "color: blue; font-size: 10px;";
				join.disabled = false;
			} else {
				check.style.cssText = "color: red; font-size: 10px;";
				join.disabled = true;
			}
			
			check.innerText = data;
		}
	}
	
	// 비밀번호
	
	pwTag.addEventListener("focus",() =>{
		pwError.innerHTML = "'숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자이상 작성해주세요";
		pwError.style.cssText = "color: red; font-size: 10px;";
	}); 
		
	pwTag.addEventListener("blur",() => {
		if(pwTag.value == ""){
			pwError.innerHTML = "";
		}else if(!regPW.test(pwTag.value)){
			pwError.innerHTML = "'숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자이상 작성해주세요";
			pwError.style.cssText = "color: red; font-size: 10px;";
			//pwTag.focus();
		}else {
			pwError.innerHTML = "";
		}
	});
	
	// 비밀번호 확인
	
	repwTag.addEventListener("blur",() =>{
		if(pwTag.value == ""){
			repwError.innerHTML = "";
		}
		else if(pwTag.value != repwTag.value){
			repwError.innerHTML = "비밀번호가 일치하지 않습니다";
			repwError.style.cssText = "color: red; font-size: 10px;";
			
		}else{
			repwError.innerHTML = "비밀번호가 일치 합니다";
			repwError.style.cssText = "color: blue; font-size: 10px;";
		}
	});
	
	


	
</script>
 
 
 
 
 
 
 
 
 