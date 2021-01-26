import java.net.*;
import java.io.*;
public class CircleServer{
static final double myPI = 3.1416;
public static void main(String args[]) throws Exception{
// establishing the connection with the server
ServerSocket sersock = new ServerSocket(4000);
System.out.println("Server ready for connection");
Socket sock = sersock.accept();
// binding with port: 4000
System.out.println("Connection is successful and waiting for interaction");
// reading the file name from client
InputStream istream = sock.getInputStream();
BufferedReader strRead =new BufferedReader(new InputStreamReader(istream));
String radius = strRead.readLine();
int iRadius;
iRadius = Integer.parseInt(radius);
double dArea;
dArea = myPI * iRadius * iRadius;
String result = "Area is " + dArea + " units";
// reading file contents
OutputStream ostream = sock.getOutputStream();
PrintWriter pwrite = new PrintWriter(ostream, true);
pwrite.println(result);
System.out.println("Closing the socket");
sock.close();
sersock.close();
// closing network sockets
pwrite.close();
strRead.close();
}
}
