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
		while((b=in.read())!=-1){
			out.write(buf, 0, b);
		}
		return out.toByteArray();
	}
	public static String down(String imgURL) throws Exception{
		return Base64Util.encode(streamToByte(new URL(imgURL).openStream()));
	}

	
}
