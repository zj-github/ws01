package c03_xml.jaxb.t1.map;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Root1")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapFieldInClass {
	Map<String,String> m ;

	public Map<String, String> getM() {
		return m;
	}

	public void setM(Map<String, String> m) {
		this.m = m;
	}

	@Override
	public String toString() {
		return "ClassC [m=" + m + "]";
	}
	
}
