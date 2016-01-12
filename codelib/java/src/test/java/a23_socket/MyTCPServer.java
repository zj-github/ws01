package a23_socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTCPServer {
	public static boolean shutdown = false;
	public static void main(String[] args) throws Exception {

		ServerSocket ss = new ServerSocket(10005);
		while (!shutdown) {
			Socket s = ss.accept();
			String ip = s.getInetAddress().getHostAddress();
			System.out.println(ip + "....connected");
			BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			String line = null;
			while ((line = bufIn.readLine()) != null) {
				System.out.println(line);
				out.println(line.toUpperCase());
			}
			s.close();
		}
		ss.close();
	}
}
