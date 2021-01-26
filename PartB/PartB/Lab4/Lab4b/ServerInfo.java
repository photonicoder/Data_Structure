import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

public class ServerInfo extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head>");
		out.println("<title>Server Information</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=center> SERVER INFORMATTION");
		out.println("<hr><br><center><table border=5><tr>");
		out.println("<td><b>Request Method</b></td>");
		out.println("<td>");
		out.println(request.getMethod());
		out.println("</td></tr>");
		out.println("<tr>");
		out.println("<td><b> URL</b></td>");
		out.println("<td>");
		out.println(request.getRequestURL());
		out.println("</td></tr>");
		out.println("<tr>");
		out.println("<td><b>Protocol </b></td>");
		out.println("<td>");
		out.println(request.getProtocol());
		out.println("</td></tr>");
		out.println("<tr>");
		out.println("<td><b>Remote Address<b></td>");
		out.println("<td>");	
		out.println(request.getRemoteAddr());
		out.println("</td></tr></table>");
		out.println("<br><hr>");
		out.println("</body></html>");
	}
}

