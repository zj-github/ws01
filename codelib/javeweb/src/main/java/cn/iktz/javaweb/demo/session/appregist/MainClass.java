package cn.iktz.javaweb.demo.session.appregist;

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
	//��ȡ���ݵ�ָ��
	public static String encode(String str) throws Exception{
		MessageDigest md = MessageDigest.getInstance("md5");
		byte b[] = md.digest(str.getBytes());//��md5�㷨�õ�������ָ��
		// 1001010101011010101111
		//�κ�����в�һ�������϶����Ʊ�ʾ���κ��ַ���ת���ɿɼ��ַ���Base64���룩
		BASE64Encoder base64 = new BASE64Encoder();
		return base64.encode(b);
	}

}
