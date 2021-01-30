

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbOperations.GetSplCode;

@WebServlet("/forgotRecovery")
public class ForgotRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Forgot p=new Forgot();
		p.setEmail(request.getParameter("email"));
		p.setSpl(request.getParameter("splcode"));	
		
		if(!Pattern.matches("[\\w]*[\\@][a-zA-Z]*[\\.][A-Za-z]*", p.getEmail())) {
			request.getSession().setAttribute("message","<blink>Type correct type of mail format</blink>");
			try {response.sendRedirect("forgot.jsp"); }
			catch (IOException e) {}
		}
		else { try{ if(GetSplCode.getSplCode(p.getEmail()).equals(p.getSpl())) {
			request.getSession().setAttribute("Remail",p.getEmail());
			response.sendRedirect("ResetPassWord.jsp"); }
		else {
			request.getSession().setAttribute("message","<blink>spl code error</blink>");
			response.sendRedirect("forgot.jsp");} }
		 catch(Exception e){
			 request.getSession().setAttribute("message","<blink>Email not in db error</blink>");
			 response.sendRedirect("forgot.jsp");}
	}
  }
}
