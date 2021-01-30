

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbOperations.SetPassword;

@WebServlet("/resetPassword")
public class Reset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("p1").equals(request.getParameter("p2"))) {
			SetPassword.setPass((String)
					request.getSession().getAttribute("Remail"),request.getParameter("p2"));
			request.getSession().setAttribute("message", "");
			response.sendRedirect("login.jsp");}
		else {
			request.getSession().setAttribute("message", "password mismatch");
			response.sendRedirect("ResetPassWord.jsp");
		}
	}

}
