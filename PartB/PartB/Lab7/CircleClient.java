import java.net.*;
import java.io.*;
public class CircleClient{
public static void main(String args[]) throws Exception {
Socket sock = new Socket( "127.0.0.1", 4000);
// reading the file name from keyboard. Uses input stream
System.out.print("Enter the radius : ");
BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
String radius = keyRead.readLine();
// sending the file name to server. Uses PrintWriter
OutputStream ostream = sock.getOutputStream( );
PrintWriter pwrite = new PrintWriter(ostream, true);
pwrite.println(radius);
// receiving the contents from server. Uses input stream
InputStream istream = sock.getInputStream();
BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
String str;
str = socketRead.readLine();
System.out.println(str);
pwrite.close();
socketRead.close();
keyRead.close();
}
}
