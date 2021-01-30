
import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Register reg = new Register();
		reg.setEmail(request.getParameter("email"));
		reg.setName(request.getParameter("name"));
		reg.setPassword(request.getParameter("password1"),request.getParameter("email"));
		reg.setSplcode(request.getParameter("splcode"));
		RegisterStore register=new RegisterStore();
		HttpSession hs=request.getSession();
		boolean p=Pattern.matches("[\\w]*[\\@][a-zA-Z]*[\\.][A-Za-z]*", reg.getEmail())?true:false;
		if(!p){
			hs.setAttribute("message","<blink>Type correct type of mail format</blink>");
			try { response.sendRedirect("Registration.jsp");   }
			catch (IOException e) {}
		}
		else if(!Pattern.matches("[A-Za-z\\s]*", reg.getName())){
			hs.setAttribute("message","<blink>Enter valid name format @ not allowed<br>"
					+ "(numbers special symbols and spaces)</blink>");
			try { response.sendRedirect("Registration.jsp");   }
			catch (IOException e) {}
		}
		else if(!(request.getParameter("password1").equals(request.getParameter("password2"))))
			{
			hs.setAttribute("message","<blink>password miss match</blink>");
			response.sendRedirect("Registration.jsp");} 
		else{
			try {
				if(register.newReg(reg)==true) {
					response.sendRedirect("sucess.jsp");	}
				else{
				hs.setAttribute("message", "user already exist ");
				response.sendRedirect("Registration.jsp");	}
			}
		catch (Exception e) {}
	}
  }
}
