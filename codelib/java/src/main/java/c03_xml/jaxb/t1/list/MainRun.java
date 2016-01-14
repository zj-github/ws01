package c03_xml.jaxb.t1.list;

import java.util.ArrayList;
import java.util.List;

import c03_xml.jaxb.t1.XmlUtil;

public class MainRun {

	public static void main(String[] args) {

		ClassRoom classRoom = new ClassRoom();
		
		List<Desk> desks = new ArrayList<>();
		
		desks.add(new Desk(16789,"zhangsan"));
		desks.add(new Desk(2898,"lisi"));
		
		classRoom.setDesks(desks);
		
		XmlUtil.toXML(classRoom);
		
//		String resource = MainRun.class.getClassLoader().getResource("c03_xml/jaxb/t1/map/m.xml").getPath();
//		MapFieldInClass fromXML = XmlUtil.fromXML(resource, MapFieldInClass.class);
		System.out.println(XmlUtil.toXML(classRoom));
//		<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
//		<classRoom>
//		    <desks>
//		        <deskId>16789</deskId>
//		        <studentName>zhangsan</studentName>
//		    </desks>
//		    <desks>
//		        <deskId>2898</deskId>
//		        <studentName>lisi</studentName>
//		    </desks>
//		</classRoom>
	}

}
