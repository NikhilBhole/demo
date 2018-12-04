<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<%-- Spring link preparation --%>
<s:url var="url_bootstrap" value="/static/css/bootstrap.min.css" />
<s:url var="url_font_awesome" value="/static/css/font-awesome.min.css" />
<s:url var="url_main" value="/static/css/main.css"></s:url>
<s:url var="url_util" value="/static/css/util.css"></s:url>

<link href="${url_bootstrap}" type="text/css" rel="stylesheet">
<link href="${url_font_awesome}" type="text/css" rel="stylesheet">
<link href="${url_main}" type="text/css" rel="stylesheet">
<link href="${url_util}" type="text/css" rel="stylesheet">

<style>
body {
    height: 100%;   
    background-size: 100%; 
    background-image: url("");
    background-repeat: no-repeat;
}
.main{
	
	
}
</style>

</head>

<body>

	<%@include file="./common/header.jsp"%>


	<!-- Begin page content -->
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div align="center" style="background-image: url("");">
		<br> <br> <br>
		<main role="main" class="container" >
		<h3>${errormsg}</h3>
		<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50" style="background-color: aqua; opacity:0.9;">
				<form class="login100-form validate-form" action="login" method="post">
					<span class="login100-form-title p-b-33">
						Account Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="loginName" placeholder="loginName">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="wrap-input100 rs1 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100-1"></span>
						<span class="focus-input100-2"></span>
					</div>

					<div class="container-login100-form-btn m-t-20">
						<button class="login100-form-btn">
							Sign in
						</button>
					</div>
                    <br>

					<div class="text-center">
						<span class="txt1">
							Create an account?
						</span>

						<a href="userRegistration" class="txt2 hov1">
							Sign up
						</a>
					</div>
				</form>
			</div>
		
		</main>
		
	</div>

	<%@include file="./common/footer.jsp"%>
</body>
</html>