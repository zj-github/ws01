package cn.iktz.jedis.test.imgdown;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class IMGDown {

	public static void main(String[] args) throws Exception{
		String url = "http://mmbiz.qpic.cn/mmbiz/GicBlLc5goGXa04IfLv1rHSQjS4Un0gRDGwE8KycibkUv9oJApH3jQw7lgVumtTBPmkmCVNC416qyshLcnje9mRQ/0?wx_fmt=png";
		
		URLConnection u = new URL(url).openConnection();
		InputStream is = u.getInputStream();
		File f = new File("e://p.png");
		OutputStream os = new FileOutputStream(f);
		
		
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("c:\\3.mp3"));

		int by = 0;
		while ((by = bis.read()) != -1) {
			bufos.write(by);
		}
		
		
		
		
	}
}
