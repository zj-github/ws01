package c00_javase.a00.cn.iktz.socket.uploadpic;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception {
		String path = "replace you file path ";
		Socket socket = new Socket("192.168.1.108", 8888);
		FileInputStream fis = new FileInputStream(new File(path));
		OutputStream out = socket.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fis.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		fis.close();
		socket.close();
	}
}
