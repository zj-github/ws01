package c00_javase.a00.cn.iktz.socket.uploadpic;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class UploadHandler implements Runnable {

	private Socket socket;

	UploadHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		InputStream in = null;
		FileOutputStream fos = null;

		try {
			in = socket.getInputStream();
			fos = new FileOutputStream(new File("filePath"));

			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = in.read()) != -1) {
				fos.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void run2() {
		InputStream in = null;
		FileOutputStream fos = null;

		try {
			in = socket.getInputStream();
			fos = new FileOutputStream(new File("filePath"));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			int len = 0;
			while ((len = in.read()) != -1) {
				baos.write(len);
			}
			// 写入目的流中
			baos.writeTo(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
