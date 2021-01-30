

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbOperations.StoreMessages;

@WebServlet("/storeMessages")
public class StoreMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message=request.getParameter("message");
		String email=(String)request.getSession().getAttribute("email");
		String tableName=(String)request.getSession().getAttribute("dbName");
		StoreMessages.store(email,message,tableName);
		response.sendRedirect("MyGalary/ChattingRoom.jsp");
		
	}

}
