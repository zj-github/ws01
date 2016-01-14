package c03_xml.jaxb.t1.map;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import c03_xml.jaxb.t1.XmlUtil;

public class MainRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MapFieldInClass classc = new MapFieldInClass();
		Map<String, String> m = new HashMap<>();
		m.put("k1", "v1");
		m.put("k2", "v2");
		classc.setM(m);
		URL resource = MainRun.class.getClassLoader().getResource("c03_xml/jaxb/t1/map/m.xml");
		MapFieldInClass fromXML = XmlUtil.fromXML(resource.getPath(), MapFieldInClass.class);
		System.out.println(fromXML);

	}

}
