package c03_xml.jaxb.t1.list;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClassRoom{

	private List<Desk> desks;

	public List<Desk> getDesks() {
		return desks;
	}

	public void setDesks(List<Desk> desks) {
		this.desks = desks;
	}
	
	
}