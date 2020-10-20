<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password],  input[type=email] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}
.login{
  	width: 500px;
  	margin: 0 auto;
  }
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
  
}
#container{
	border: 1px solid #cccc;
    border-top-left-radius: 20px;
    border-top-right-radius: 20px;
}
span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
  
}
</style>
</head>
<body>

<h2>Login Form</h2>
<div class="login">
	<!-- <form action="" method="post"> -->
	  <div class="imgcontainer">
	    <img src="resources/img/logo.png" alt="Avatar" class="avatar">
	  </div>
	
	  <div class="container">
	  	<div id="containerLogin">
		    <label for="uname"><b>Username</b></label>
		    <input id="uname" type="text" placeholder="Enter Username" name="uname"  autocomplete="on" required>
		
		    <label for="psw"><b>Password</b></label>
		    <input id="psw" type="password" placeholder="Enter Password"  autocomplete="off" name="psw" required>
		    
		    <button type="button" id="btnLogin">Đăng nhập</button>
	    </div>
	    
	    <div id="containerSignup" style="display: none;">
	    <form action="" method="post">
	    	<label for="email"><b>Email</b></label>
		    <input id="email" type="email" placeholder="Enter Email" name="email"  autocomplete="on" required>
		    
		    <label for="fullname"><b>Full name</b></label>
		    <input id="fullname" type="text" placeholder="Enter fullname" name="fullname"  autocomplete="on" required>
		    
		    <label for="uname"><b>Username</b></label>
		    <input id="uname" type="text" placeholder="Enter Username" name="uname"  autocomplete="on" required>
		
		    <label for="psw"><b>Password</b></label>
		    <input id="psws" type="password" placeholder="Enter Password"  autocomplete="off" name="psw" required>
		    
		    <label for="cpsw"><b>Confirm Password</b></label>
		    <input id="cpsw" type="password" placeholder="Enter Password"  autocomplete="off" name="cpsw" required>
		    
		    <button type="submit" id="btnSignin">Đăng kí</button>
		</form>
	    </div>
	  </div>
	
	  <div class="container" style="background-color:#f1f1f1">
	    <button type="button" class="cancelbtn" id="dangki" >Đăng kí</button>
	    <button type="button" class="cancelbtn" id="dangnhap" style="display: none;">Đăng nhập</button>
	    <span class="psw">Forgot <a href="#">password?</a></span>
	    <!-- <button type="button" id="btnLogin">Check đăng nhập</button> -->
	  </div>
	<!-- </form> -->
	<span id="Kqua"></span>
</div>
<%@include file="comon/foot.jsp" %>
<script type="text/javascript">
	var password = document.getElementById("psws");
	var confirm_password = document.getElementById("cpsw");
	function validatePassword(){
		if(password.value != confirm_password.value) {
  			confirm_password.setCustomValidity("Mật khẩu không trùng khớp!");
		} else {
  			confirm_password.setCustomValidity('');
			}
		}
		password.onchange = validatePassword;
		confirm_password.onkeyup = validatePassword;
</script>
</body>
</html>
