
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Super App2</title>
</head>
<body onload="checkCookie()">
<%@ page import="gr.teiath.cs.User,gr.teiath.cs.LoginCaptcha" %>
	<%

    try{
		Cookie[] cookies = request.getCookies();
			String email="";
			String username="";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("email")) {
			email = cookies[i].getValue();
			}
			if (cookies[i].getName().equals("username")) {;
				username = cookies[i].getValue();	
			}
			if((!username.equals(""))&&(!email.equals("")))
			{

				 out.println(username);
				 out.println(email);

						User user = new User();

				user.setLastName(email);
				user.setUsername(username);
				session.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/welcome.jsp");
				rd.forward(request, response);
				break;
				
		
			}
			}

    }
    catch (Exception e){
        out.println("Logged out!");
    }
		
		%>
	<h2>Login</h2>
	<form action="LoginCaptcha" method="POST">
		Username:<input type="text" name="username"><br>
		Password:<input type="password" name="password"><br>
					
		 <img
			src="CaptchaGenerator"> <input type="text" maxlength="5"
			size="5" name="usercaptcha"><br> 
<input type="checkbox" name="addcookie" value="remember" checked> Remember me<br>
			<input type="submit" value="Login" onclick = "setCookie(document.getElementById('username').value)">

	</form>
	 <form action="Register" method="POST">
<input type="submit" value="Register">  
	</form>
</body>
</html>