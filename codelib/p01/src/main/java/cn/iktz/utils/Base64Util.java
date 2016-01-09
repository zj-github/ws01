package cn.iktz.utils;

import java.io.IOException;
import java.io.InputStream;

import sun.misc.BASE64Decoder;

public class Base64Util {

	/**
	 * 字节码转字符串
	 * @param bs
	 * @return
	 */
	public static String encode(byte[] bs){
		return new sun.misc.BASE64Encoder().encode(bs);
	}
	
	public static byte[] decode(String str) {
		try {
			return new BASE64Decoder().decodeBuffer(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] decode(InputStream is) {
		try {
			return new BASE64Decoder().decodeBuffer(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
