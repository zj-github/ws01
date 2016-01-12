package c00_javase.a26_serialize.messagepack;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;
import org.msgpack.unpacker.Unpacker;

public class Demo1 {

//	public static void main(String[] args) throws Exception {
//		List<String> src = new ArrayList<String>();
//		
//		src.add("a");
//		src.add("b");
//		src.add("c");
//		MessagePack msgpack = new MessagePack();
//		byte[] raw = msgpack.write(src);
//		
//		List<String> dst1 = msgpack.read(raw,Templates.tList(Templates.tString()));
//		
//	} 
	public static void main(String[] args) throws IOException {
//        UserStruct stu = new UserStruct();
//        stu.DeviceID = "DeviceID";
//        stu.Password = "Password";
         
        String url = "http://mmbiz.qpic.cn/mmbiz/GicBlLc5goGXa04IfLv1rHSQjS4Un0gRDGwE8KycibkUv9oJApH3jQw7lgVumtTBPmkmCVNC416qyshLcnje9mRQ/0?wx_fmt=png";
		
		URLConnection u = new URL(url).openConnection();
		InputStream is = u.getInputStream();
		
		BufferedInputStream bis = new BufferedInputStream(is);
//		os.write(b);
		MessagePack pack = new MessagePack();
        Unpacker p = pack.createUnpacker(bis);
        
//        p.
        //序列化
//        byte[] bytes = pack.write(stu);
         
//        //反序列化
//        UserStruct s = pack.read(bytes, UserStruct.class);
//        System.out.println("DeviceID: "+s.DeviceID);
    }

}
