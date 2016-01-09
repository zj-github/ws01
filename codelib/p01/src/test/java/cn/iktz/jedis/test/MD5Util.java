package cn.iktz.jedis.test;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class MD5Util {
	public static String encoderByMd5(String str) throws Exception {
		// 确定计算方法
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		// 加密后的字符串
		String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return newstr;
	}
	public static void main(String[] args) throws Exception {
		String d="http://mmbiz.qpic.cn/mmbiz/8XkvNnTiapOOyiaZ31Jb4E8VC4Z6l7dnJaHD9AUG2slPfC2v0sT0LP5fbFa5icRbAk1Tiamt2d7bXuMqIjyqhbBCdg/0?wx_fmt=png";
		String encoderByMd5 = encoderByMd5(d);
		System.out.println(encoderByMd5);
	}
}
