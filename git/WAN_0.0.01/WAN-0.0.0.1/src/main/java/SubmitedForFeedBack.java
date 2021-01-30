

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbOperations.StoreFeedBack;

@WebServlet("/SubmitedForFeedBack")
public class SubmitedForFeedBack extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoreFeedBack.store((String)request.getParameter("feedback"));
		response.sendRedirect("FeedBacks.html");
	}

}
