package cn.iktz.web.project.a05_mvcframe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "context")
@XmlAccessorType(XmlAccessType.FIELD)
public class MVCContext {

	@XmlElement(name = "component-scan")
	private String scanPackage;

	public String getScanPackage() {
		return scanPackage;
	}

	public void setScanPackage(String scanPackage) {
		this.scanPackage = scanPackage;
	}

	@Override
	public String toString() {
		return "MVCContext [controllerClassPackage=" + scanPackage + "]";
	}

}
