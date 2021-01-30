

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbOperations.DeleteVideosFromDb;
@WebServlet("/deleteVideos")

public class DeleteVideos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		if(request.getSession().getAttribute("email").equals(null)) {
			request.getSession().setAttribute("message", "login again credentials expired");
			response.sendRedirect("error.jsp");
		}
		else {
			String email = (String) request.getSession().getAttribute("email");
			String choice=request.getParameter("choice");
			String id=request.getParameter("id");
			if(choice.equalsIgnoreCase("G")) {
				
				if(DeleteVideosFromDb.deleteData(email, id)) {
					response.sendRedirect("Home.jsp");
				}
				else {
					request.getSession().setAttribute("message", "Something error try again");
					response.sendRedirect("error.jsp");
				}
			}
			else if(choice.equalsIgnoreCase("A")){
				if(DeleteVideosFromDb.deleteDataAll(email, id)) {
					response.sendRedirect("Home.jsp");
				}
				else {
					request.getSession().setAttribute("message", "Something error try again");
					response.sendRedirect("error.jsp");
				}
			}
			else {
				request.getSession().setAttribute("message", "Modification errors try again ");
				response.sendRedirect("error.jsp");
			}
		}
	}catch (Exception e) {
		System.out.println("errror "+ e);
		request.getSession().setAttribute("message", "Exception occur try again");
		
		response.sendRedirect("error.jsp");
	}

	}
}
