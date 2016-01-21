package gr.teiath.cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();		
		try {
			LoginCaptcha.emailusername.put("admin", "admin");
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet CookiesCounter</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>All Users</h2>");
			out.println("<ul>");
		    for (Map.Entry<String, String> entry : LoginCaptcha.emailusername.entrySet()) {
		        String key = entry.getKey().toString();
		        String value = entry.getValue();
		        System.out.println("key, " + key + " value " + value );
		        out.println("USERNAME : " + key + " NAME : " + value );
		        out.println("<br>");
		    }
		    out.println("<form action=\"DeleteUser\" method=\"POST\">");
		    out.println("User to delete :<input type=\"text\" name=\"username\"><br>");
		    out.println("<input type=\"submit\" value=\"Delete\" >");
		    out.println("</form>");					 
		    out.println(" <button onclick=\"goBack()\">Go Back</button>");
		    out.println("<script>");
		    out.println(" function goBack() {");
		    out.println("    window.history.back();");
		    out.println(" }");
		    out.println(" </script>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
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
