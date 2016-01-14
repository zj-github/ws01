package c03_xml.jaxb.t1.list;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import c03_xml.jaxb.t1.XmlUtil;
import c03_xml.jaxb.t1.map.MapFieldInClass;

public class MainRun {

	public static void main(String[] args) {

		ClassRoom classc = new ClassRoom();
		
		List<Desk> desks = new ArrayList<>();
		
		desks.add(new Desk());
		
		URL resource = MainRun.class.getClassLoader().getResource("c03_xml/jaxb/t1/map/m.xml");
		MapFieldInClass fromXML = XmlUtil.fromXML(resource.getPath(), MapFieldInClass.class);
		System.out.println(fromXML);
	}

}
