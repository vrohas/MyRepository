<%@page import="gr.teiath.cs.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error During Login</title>
</head>
<body>
	<%
		String message = "";
		if (session.getAttribute("message") != null) {
			message = (String) session.getAttribute("message");
		}
	%>
	<h1>Error During Login</h1>
	<h2><%=message%></h2>
</body>
</html>