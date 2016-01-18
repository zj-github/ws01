package c00_javase.a26_serialize.messagepack;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		//���л�
		byte[] raw = msgpack.write(src);

		//�����л�
		List<String> dst1 = msgpack.read(raw, Templates.tList(Templates.TString));
		for(String d :dst1)
			System.out.println(d);
	}

}
