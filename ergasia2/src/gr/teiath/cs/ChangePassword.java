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
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opassword = request.getParameter("opassword");
		String npassword = request.getParameter("npassword");
		String email = request.getParameter("email");
		String address;
		String error;

		HttpSession session = request.getSession();



				if (opassword.equals(LoginCaptcha.emailpassword.get(email))&&(npassword.length()>3)) {
					LoginCaptcha.emailpassword.put(email,LoginCaptcha.emailpassword.get(email) +1 );
					address = "WEB-INF/jsps/PasswordChange.html";
				} else {
					error = "Incorrect password";
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


