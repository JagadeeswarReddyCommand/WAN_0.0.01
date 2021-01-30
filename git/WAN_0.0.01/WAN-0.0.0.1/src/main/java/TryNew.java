
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/TryNew")
public class TryNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		  FileItemFactory itemfactory = new DiskFileItemFactory(); 
		  ServletFileUpload upload = new ServletFileUpload(itemfactory);
		  try{
		   List<FileItem>  items = upload.parseRequest(request);
		   for(FileItem item:items){
		    String contentType = item.getContentType();
		    if(!contentType.equals("image/png")){
		     out.println("only png format image files supported");
		     continue;
		    }
		    File uploadDir = new File("D:\\jag");
		    File file = File.createTempFile("imgs",".jpg",uploadDir);
		    item.write(file);
		    out.println("File Saved Successfully");
		   }
		  }
		  catch(FileUploadException e){
		   out.println("upload fail");
		  }
		  catch(Exception ex){
		   out.println("can't save");
		  }}
}
