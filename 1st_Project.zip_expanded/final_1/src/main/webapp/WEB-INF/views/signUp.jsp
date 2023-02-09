<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
   $(function() {
	    var $id = $("#id");
	    var $pw = $("#pw");
	    var $pwConfirm = $("#pwConfirm");
	    $("#labelId").hide();
	    $("#labelPw").hide();
	    $("#labelPwConfirm").hide();
	
		$id.on("keyup", function(){
	        var regExp = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	
	        if(!regExp.test($id.val())){
	            var idchk = false;
	            $("#labelId").show();
	            $("#labelId").html("<span id='check'>사용할 수 없는 아이디입니다</span>");
	            $("#check").css({
	                "color" : "red",
	                "font-weight" : "bold",
	                "font-size" : "15px"
	            })
	        } else{
	            $.ajax({
	                url : "idChk",
	                type:"POST",
	                data : {
	                        "type" : "user",
	                        "id" : $id.val()
	                },
	                success : function(data){
	                    if(data == 1){
	                        $("#labelId").html("<span id='check'>이미 존재하는 아이디입니다</span>");
	                        $("#check").css({
	                            "color" : "red",
	                            "font-weight" : "bold",
	                            "font-size" : "15px"
	                        })
	                    }else{
	                        idchk=true;
	                        $("#labelId").html("<span id='check'>사용가능한 아이디입니다</span>");
	
	                        $("#check").css({
	                            "color" : "blue",
	                            "font-weight" : "bold",
	                            "font-size" : "15px"
	                        })
	                    }
	                }
	            })
	        }
        
    	})

		$pw.on("keyup", function(){
			var regExp = /^[a-z]+[a-z0-9]{5,15}$/g;
		      if(!regExp.test($pw.val())){
		          $("#labelPw").show();
		          $("#labelPw").html("<span id='check'>비밀번호는 특수문자 포함 5자리 이상입니다</span>");
		          $("#check").css({
		              "color" : "red",
		              "font-weight" : "bold",
		              "font-size" : "15px"
		          })
		      }else{
		      	$("#labelPw").hide();
		      }
		});
	    
	    $pwConfirm.on("keyup", function(){
			var password = document.getElementById('pw');
			var passwordConfirm = document.getElementById('pwConfirm');

			if(password.value == passwordConfirm.value){
	        	$("#labelPwConfirm").show();
	            $("#labelPwConfirm").html("<span id='check'>비밀번호 일치!</span>");
	        }else{
	        	$("#labelPwConfirm").show();
	            $("#labelPwConfirm").html("<span id='check'>비밀번호 불일치!</span>");
	        }
	   	});
	    
	});

</script>
</head>
<body>
<h1>회원가입</h1>
<form action="register" method="post">
	<table border="1">
		<tr> 
			<td><input type="text" id="id" name="id" placeholder="아이디" required="required"></td>
            <td><label id="labelId">아이디를 입력해주세요.</label></td>
		</tr>
		<tr>
			<td><input type="text" id="pw" name="pw" placeholder="비밀번호" required="required"></td>
			<td><label id="labelPw">비밀번호를 확인해주세요.</label></td>
		</tr>
        <tr>
			<td><input type="text" id="pwConfirm" placeholder="비밀번호 재입력" required="required"></td>
            <td><label id="labelPwConfirm">비밀번호를 확인해주세요.</label></td>
		</tr>
        <tr>
			<td><input type="text" name="name" placeholder="이름" required="required"></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="회원가입" onclick="/signupform">
				<input type="button" value="취소" onclick="/loginform">
			</td>
		</tr>
	</table>
</form>
</body>
</html>