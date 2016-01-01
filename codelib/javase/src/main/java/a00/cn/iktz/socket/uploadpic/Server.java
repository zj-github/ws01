package a00.cn.iktz.socket.uploadpic;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8888);
			while (true) {
				Socket socket = ss.accept();
				new Thread(new UploadHandler(socket)).start();
			}
		} finally {
			ss.close();
		}
	}
}
