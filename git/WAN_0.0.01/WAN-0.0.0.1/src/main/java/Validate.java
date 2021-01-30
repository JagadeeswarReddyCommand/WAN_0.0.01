

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DbOperations.*;

@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession hs=request.getSession();
		Login log=new Login();
		log.setEmail(request.getParameter("email"));
		boolean p=Pattern.matches("[\\w]*[\\@][a-zA-Z]*[\\.][A-Za-z]*", log.getEmail())?true:false;
		log.setPassword(request.getParameter("password"));
		if(!p) {
			hs.setAttribute("message","<blink><A>Type correct type of mail format<a></blink>");
			try {response.sendRedirect("login.jsp");}
			catch (IOException e) {}
		}
		else if(ValidateLogin.validate(log)) { 
			hs.setAttribute("email",request.getParameter("email"));
			hs.setAttribute("person", GetName.getName(request.getParameter("email")));
			try {response.sendRedirect("Home.jsp");}
			catch (IOException e) {}
			}
		else {
			hs.setAttribute("message","<blink><A>error in login try again<a></blink>");
			try {response.sendRedirect("login.jsp");}
			catch (IOException e) {}
			}
			}
		}
