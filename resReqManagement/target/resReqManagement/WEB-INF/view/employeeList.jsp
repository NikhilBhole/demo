<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
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
    background-image: url("../static/images/expense.jpeg");
    background-repeat: no-repeat;
}

.content h2{
	color: black;
	font-weight: 600;
}
.content p{
	color: black;
	font-weight: 600;
	font-size: large;
}
</style>
</head>

<body>
	<% 
		if(session.getAttribute("userId") == null)
		{
			out.println(session.getAttribute("userId"));
			System.out.println("session id = "+session.getId()+" session interval="+session.getMaxInactiveInterval());
			response.sendRedirect("login.jsp");
		}
	%>

<%@include file="./common/managerHeader.jsp" %>

	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div align="center" style="background-image: url("");">
		<br> <br> <br>
	<main role="main" class="container">
    <h3>${errormsg}</h3>
		<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50" style="background-color: aqua; opacity:0.9; width: 100%;">
					<span class="login100-form-title p-b-33">
						Employee List
					</span>
					<table border="1px" style="width:100%; padding: 10px; text-align: center;">
		    			<tr style="color: red;">
		    				<th>Employee ID</th>
        	    			<th>Employee Name</th>
            				<th>Designation</th>  
            				<th>Phone Number</th>                            
         				</tr>
        				<c:forEach items="${employeeList}" var="employee">
        	   			<tr>
        	   				<td><a href="employeeProfile?id=${employee.employeeId}"><c:out value="${employee.employeeId}"></c:out></a></td>
   		     	    		<td><c:out value="${employee.firstName}"></c:out>&nbsp;<c:out value="${employee.lastName}"></c:out></td>
                			<td><c:out value="${employee.designation}"></c:out></td>
                			<td><c:out value="${employee.phoneNumber}"></c:out></td>
            			</tr>
        				</c:forEach>
        			</table>
			</div>
    </main>
</div>

<%@include file="./common/footer.jsp" %>

</body>
</html>