package c03_xml.jaxb.t1;

import java.io.FileInputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtil {

    public static String toXML(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //�����ʽ
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// �Ƿ��ʽ�����ɵ�xml��
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// �Ƿ�ʡ��xmͷ������Ϣ
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromXML(String xml, Class<T> valueType) {
        try {
            JAXBContext context = JAXBContext.newInstance(valueType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileInputStream in = new FileInputStream(xml);
            return (T) unmarshaller.unmarshal(in);
//            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
    }
}

