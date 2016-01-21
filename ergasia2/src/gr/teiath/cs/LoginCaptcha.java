package gr.teiath.cs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCaptcha
 */

@WebServlet("/LoginCaptcha")
public class LoginCaptcha extends HttpServlet {
	public static HashMap<String, String> emailpassword = new HashMap<String, String>();
	{
		emailpassword.put("admin", "admin");
		emailpassword.put("test", "test");
	}
    public static HashMap<String, String> emailusername = new HashMap<String, String>();
	{
	emailusername.put("admin", "admin");
	emailusername.put("test", "test");
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try
		{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        String remember = request.getParameter("addcookie");
		String address;
		String error;
		Cookie c = null;
		HttpSession session = request.getSession();
		String captcha = (String) session.getAttribute("captcha");	
		if (request.getParameter("usercaptcha").equals(captcha)) {
			if (!username.equals("")) {
				if (password.equals(emailpassword.get(username))) {
					if(remember.equals("remember")){		
					 c = new Cookie("email", username);
						response.addCookie(c);
						System.out.println(username);
					 c = new Cookie("username", emailusername.get(username));
						response.addCookie(c);
						System.out.println(emailusername.get(username));
					System.out.println(c);
					}
				    User user = new User();			
					user.setUsername(emailusername.get(username));
					user.setLastName(username);
					session.setAttribute("user", user);
					address = "WEB-INF/jsps/welcome.jsp";
				} else {
					error = "Wrong Password";
					session.setAttribute("message", error);
					address = "WEB-INF/jsps/fail.jsp";
				}
			} else {
				error = "User does not exist!";
				session.setAttribute("message", error);
				address = "WEB-INF/jsps/fail.jsp";
			}

		} else {
			error = "Wrong Number!";
			session.setAttribute("message", error);
			address = "WEB-INF/jsps/fail.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);
		}
		catch(Exception e)
		{
			HttpSession session = request.getSession();
			session.setAttribute("message","You must login first!");
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsps/fail.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
}
