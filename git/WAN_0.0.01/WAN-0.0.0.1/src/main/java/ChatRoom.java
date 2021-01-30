

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbOperations.GetChatDbName;

@WebServlet("/chatRoom")
public class ChatRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		if(request.getSession().getAttribute("email").equals(null)) {
				response.sendRedirect("error.jsp?messge=email not found login first");	}
		else {
			String dbName =	GetChatDbName.getDbrequest(
				request.getParameter("from") ,request.getParameter("to"));	
			if(dbName.equalsIgnoreCase(null)){
				response.sendRedirect("error.jsp?message=illegal access denied");	}
			else {
				System.out.println(dbName);
				request.getSession().setAttribute("dbName", dbName);
				response.sendRedirect("MyGalary/ChattingRoom.jsp");	}
			}
		}
		catch(Exception e) {response.sendRedirect("error.jsp");}
	}
}
