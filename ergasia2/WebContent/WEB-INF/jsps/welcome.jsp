<%@page import="gr.teiath.cs.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<%
	try
	{
	String error;
	String address;
	String email;
		User user = (User) session.getAttribute("user");
	 email = user.getLastName();
	if (email.length()<4){
		error = "You must login first!";
		session.setAttribute("message", error);
		address = "WEB-INF/jsps/fail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);
	}
	if( user.getUsername().equals("admin"))
	{%>
	
		</h1>
		<form action="AdminPage" method="POST">

		<br> <input type="submit" value="Administration tools">
			        
	</form>
	<% } 	%>

	<h1>
		Welcome
		<%=user.getUsername()%>
	</h1>
		<form action="ChangePassword" method="POST">
		Old Password: <input type="password" name="opassword"><br>
		New Password:<input type="password" name="npassword"><br>
		<input type="hidden" name ="email" value=<%=email%>></p> 
		<br> <input type="submit" value="Change Password">
			        
	</form>
			<form action="Clearcookies" method="POST">
		<br> <input type="submit" value="Logout">	        
	</form>
	 <%   }
    catch (Exception e){
	
		session.setAttribute("message","You must login first!");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/fail.jsp");
		rd.forward(request, response);
    }%>
</body>
</html>