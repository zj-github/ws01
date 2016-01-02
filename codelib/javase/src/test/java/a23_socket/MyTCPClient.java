package a23_socket;

/*

需求：建立一个文本转换服务器。
客户端给服务端发送文本，服务单会将文本转成大写在返回给客户端。
而且客户度可以不断的进行文本转换。当客户端输入over时，转换结束。

分析：
客户端：
既然是操作设备上的数据，那么就可以使用io技术，并按照io的操作规律来思考。
源：键盘录入。
目的：网络设备，网络输出流。
而且操作的是文本数据。可以选择字符流。

步骤
1，建立服务。
2，获取键盘录入。
3，将数据发给服务端。
4，后去服务端返回的大写数据。
5，结束，关资源。

都是文本数据，可以使用字符流进行操作，同时提高效率，加入缓冲。


*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyTCPClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 10005);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line))
				break;
			out.println(line);
			String str = bufIn.readLine();
			System.out.println("server:" + str);

		}

		bufr.close();
		s.close();
	}
}

