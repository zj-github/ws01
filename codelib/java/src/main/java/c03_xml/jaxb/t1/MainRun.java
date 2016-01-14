package c03_xml.jaxb.t1;

public class MainRun {

    /**
     * @param args
     */
    public static void main(String[] args) {
    	Class<ClassA> valueType = ClassA.class;
		ClassA fromXML = XmlUtil.fromXML("E:\\githome\\ws01\\codelib\\java\\src\\main\\java\\c03_xml\\jaxb\\t1\\NewFile1.xml", valueType);
        System.out.println(fromXML.toString());
    }
}

