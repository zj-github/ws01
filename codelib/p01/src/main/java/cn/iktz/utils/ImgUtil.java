package cn.iktz.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImgUtil {
	public static byte[] streamToByte(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();  
		int b = 0;
		byte[] buf = new byte[1024];
		while((b=in.read(buf))!=-1){
//			System.out.println(" size "+b);
			out.write(buf, 0, b);
		}
		
		byte[] byteArray = out.toByteArray();
//		for (byte bd : byteArray) {
//			System.out.println( " **------------------- "+bd);
//		}
		return byteArray;
	}
	public static String down(String imgURL) throws Exception{
		byte[] streamToByte = streamToByte(new URL(imgURL).openStream());
//		for (byte b : streamToByte) {
//			System.out.println( " ** "+b);
//		}
		return Base64Util.encode(streamToByte);
	}

	public static void main(String[] args) {
		try {
			down("http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapOOyiaZ31Jb4E8VC4Z6l7dnJaHD9AUG2slPfC2v0sT0LP5fbFa5icRbAk1Tiamt2d7bXuMqIjyqhbBCdg/0?wx_fmt=png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
