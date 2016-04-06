import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class socketserver
{
	public static void main(String[] args) throws IOException
	{
	ServerSocket server = null;
	Socket  client;
	try
	{
		server = new ServerSocket(1225);
	}
	catch(IOException ie)
	{
		System.out.println("Cannot open socket.");
		System.exit(1);
	}

	String temp;
	while(true)
	{
	try
	{
		client = server.accept();
		OutputStream clientOut =  client.getOutputStream();
		PrintWriter pw = new PrintWriter(clientOut,true);
		InputStream clientIn = client.getInputStream();
		BufferedReader br =  new BufferedReader(new InputStreamReader(clientIn));
		temp = br.readLine();
		System.out.println(temp);
		pw.println(temp);
		br.close();
		pw.close();
		clientIn.close();
		clientOut.close();
	}
	catch(IOException ie)
	{
		ie.printStackTrace();
	}
	}
	}
}
