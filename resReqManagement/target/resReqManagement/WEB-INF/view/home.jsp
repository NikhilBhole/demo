<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource Requirement Management</title>

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
.mt-5{
	font-weight: 500;
	color: black;
	
}
</style>

</head>

<body>
	
    <%@include file="./common/header.jsp"%>
	`<div class="main">
	    <!-- Begin page content -->
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <main role="main" class="container">
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	      <div align="center" ><br><h2 class="mt-5">Resource Requirement Management</h2></div>
	    </main>
	</div>
<%@include file="./common/footer.jsp"%>
    
</body>
</html>