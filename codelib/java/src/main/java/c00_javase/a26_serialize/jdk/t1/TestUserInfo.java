package c00_javase.a26_serialize.jdk.t1;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class TestUserInfo {

	public static void main(String[] args) throws Exception {
		UserInfo info = new UserInfo();
		info.buildID(100).buildUserName("welcome");
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bos);
		os.writeObject(info);
		os.flush();
		os.close();
		byte[] b = bos.toByteArray();
		
		System.out.println("length >> "+b.length);
		System.out.println("length2 >> "+info.codeC().length);
	}
}
