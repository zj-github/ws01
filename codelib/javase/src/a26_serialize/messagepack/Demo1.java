package a26_serialize.messagepack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

public class Demo1 {

	public static void main(String[] args) throws Exception {
		List<String> src = new ArrayList<String>();
		
		src.add("a");
		src.add("b");
		src.add("c");
		MessagePack msgpack = new MessagePack();
		byte[] raw = msgpack.write(src);
		
		List<String> dst1 = msgpack.read(raw,Templates.tList(Templates.tString()));
		
		
				
		
		
	}
}
