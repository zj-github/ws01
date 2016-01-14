package c03_xml.jaxb.t1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="classA")
public class ClassA {
	
/*	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<Root1>
	    <classAId>11</classAId>
	    <classAName>A1</classAName>
	    <classB>
	        <classBId>22</classBId>
	        <classBName>B2</classBName>
	    </classB>
	</Root1>*/
    private int classAId;
    private String classAName;

    private ClassB classB;

    public int getClassAId() {
        return classAId;
    }

    public void setClassAId(int classAId) {
        this.classAId = classAId;
    }

    public String getClassAName() {
        return classAName;
    }

    public void setClassAName(String classAName) {
        this.classAName = classAName;
    }

    public ClassB getClassB() {
        return classB;
    }

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }

	@Override
	public String toString() {
		return "ClassA [classAId=" + classAId + ", classAName=" + classAName + ", classB=" + classB + "]";
	}
    
}

