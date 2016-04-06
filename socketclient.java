import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class socketclient
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
	String temp = " ";

	do
	{
	try
	{
		Socket client = new Socket(InetAddress.getLocalHost(),1225);
		InputStream clientIn = client.getInputStream();
		OutputStream clientOut = client.getOutputStream();
		PrintWriter pw = new PrintWriter(clientOut,true);
		BufferedReader br =  new BufferedReader(new InputStreamReader(clientIn));
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Type message for the server : ");
		temp = stdIn.readLine();
		pw.println(temp);
		System.out.println("Serverage : ");
		System.out.println(br.readLine());
		br.close();
		pw.close();
		client.close();
	}
	catch(ConnectException ce)
	{
		System.out.println("Connected to the server ");
	}
	catch(IOException ie)
	{
		System.out.println("I/Or.");
	}
	}
	while(!temp.matches("EXIT"));
	}
}
