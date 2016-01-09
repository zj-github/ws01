package cn.iktz.jedis.test.imgdown;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import cn.iktz.utils.Base64Util;

public class IMGDown {

	public static void main(String[] args) throws Exception {
		String url = "http://mmbiz.qpic.cn/mmbiz/GicBlLc5goGXa04IfLv1rHSQjS4Un0gRDGwE8KycibkUv9oJApH3jQw7lgVumtTBPmkmCVNC416qyshLcnje9mRQ/0?wx_fmt=png";

		File f = new File("e://p.png");
		OutputStream os = new FileOutputStream(f);

		// BufferedInputStream bis = new BufferedInputStream(in);
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);

		byte[] content = out.toByteArray();
		for (byte b : content) {
			System.out.println(b);
		}
		String d = new sun.misc.BASE64Encoder().encode(content);
		System.out.println(d);
	}

	public static byte[] getIMGByteByUrl(String url) throws Exception {
		URLConnection u = new URL(url).openConnection();
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);

		byte[] content = out.toByteArray();
		return content;
//		return Base64Util.decode(u.getInputStream());
	}

	/**
	 * 把字节数组转成图片
	 * 
	 * @throws Exception
	 */
	@Test
	public void dd() throws Exception {
		String url = "http://mmbiz.qpic.cn/mmbiz/GicBlLc5goGXa04IfLv1rHSQjS4Un0gRDGwE8KycibkUv9oJApH3jQw7lgVumtTBPmkmCVNC416qyshLcnje9mRQ/0?wx_fmt=png";
		FileOutputStream fos = new FileOutputStream("e:\\t.png");
		byte[] bs = IMGDown.getIMGByteByUrl(url);
		IOUtils.write(bs, fos);
	}
	/**
	 * 通过img中转成byte[]
	 * @throws Exception
	 */
	@Test
	public void t() throws Exception {
		String url = "http://mmbiz.qpic.cn/mmbiz/GicBlLc5goGXa04IfLv1rHSQjS4Un0gRDGwE8KycibkUv9oJApH3jQw7lgVumtTBPmkmCVNC416qyshLcnje9mRQ/0?wx_fmt=png";
		InputStream in = new URL(url).openStream();
		FileOutputStream out = new FileOutputStream(new File("e:\\d2.png"));
		IOUtils.write(m1(in), out);
	}

	/**
	 * 直接将input转换成byteoutput 然后转成数组
	 * 
	 */
	@Test
	public void t2() throws Exception {
		String url = "http://mmbiz.qpic.cn/mmbiz/GicBlLc5goGXa04IfLv1rHSQjS4Un0gRDGwE8KycibkUv9oJApH3jQw7lgVumtTBPmkmCVNC416qyshLcnje9mRQ/0?wx_fmt=png";
		InputStream in = new URL(url).openStream();
		byte[] m2 = m2(in);
		FileOutputStream out = new FileOutputStream(new File("e:\\d3.png"));
		IOUtils.write(m2, out);
	}

	private byte[] m2(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();  
		int b = 0;
		byte[] buf = new byte[1024];
		while((b=in.read())!=-1){
			out.write(buf, 0, b);
		}
		return out.toByteArray();
	}
	
	
	
	
	private byte[] m1(InputStream openStream) throws IOException {
		BufferedImage image = ImageIO.read(openStream);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();      //字节输出流
		ImageIO.write(image, "png", bos);      //将虚拟图片信息写入到字节输出流中
		byte[] b = bos.toByteArray();//generate byte[]     //输出流将字节信息输出到byte数组b中
		return b;
	}
	
	
}
