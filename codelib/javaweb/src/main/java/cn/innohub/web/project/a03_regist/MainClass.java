package cn.innohub.web.project.a03_regist;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class MainClass {

	public static void main(String[] args) throws Exception {
//		for(int i=0;i<100;i++)
//		{
//			String token = System.currentTimeMillis()+""+new Random().nextLong();
//			System.out.println(encode(token));
//		}
		String s = " ";
		System.out.println(encode(s));
		for(int i=0;i<100;i++){
			System.out.println(new BigInteger(165, new Random()).toString(36).toUpperCase());
		}
	}
	//获取数据的指纹
	public static String encode(String str) throws Exception{
		MessageDigest md = MessageDigest.getInstance("md5");
		byte b[] = md.digest(str.getBytes());//用md5算法得到的数据指纹
		// 1001010101011010101111
		//任何码表中不一定有以上二进制表示的任何字符：转换成可见字符（Base64编码）
		BASE64Encoder base64 = new BASE64Encoder();
		return base64.encode(b);
	}

}
