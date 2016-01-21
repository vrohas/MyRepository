package gr.teiath.cs;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCaptcha
 */

@WebServlet("/RegisterSubmit")
public class RegisterSubmit extends HttpServlet {


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address;
		String error;

		HttpSession session = request.getSession();

			if (username.length()>3) {
				if (password.length()>3) {
					if((email.length()>5)&&(email.indexOf("@")>0)&&(email.indexOf(".")>0)){
			
			
					LoginCaptcha.emailpassword.put(email, password);
					LoginCaptcha.emailusername.put(email, username);
					address = "/index.jsp";
				} else {
					error = "Invalid email";
					session.setAttribute("message", error);
					address = "WEB-INF/jsps/fail.jsp";
				}
			} else {
				error = "Password must be longer than 3 digits!";
				session.setAttribute("message", error);
				address = "WEB-INF/jsps/fail.jsp";
			}

		} else {
			error = "Username must be longer than 3 digits!";
			session.setAttribute("message", error);
			address = "WEB-INF/jsps/fail.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(address);
		rd.forward(request, response);
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
