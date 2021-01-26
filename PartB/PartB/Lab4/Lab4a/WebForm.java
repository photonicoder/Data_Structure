import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class WebForm extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
    	String name, addr;
		response.setContentType("text/html");
		name=request.getParameter("uname");
		addr=request.getParameter("address");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<h1 align=center> Welcome " + name + "</h1><hr>Address:" + addr);
		out.close();
	}
}

