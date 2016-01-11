package a27_xml.jaxb;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Snippet {
	public void XmlToObj() {

		try {

			File file = new File("C:\\TestJaxb.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Student stu = (Student) unmarshaller.unmarshal(file);
			System.out.println(stu.getName() + "..." + stu.getBirthDate());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void Obj2Xml() {
		File xmlFile = new File("C:/TestJaxb.xml");
		JAXBContext ctx;
		try {

			ctx = JAXBContext.newInstance(Student.class);

			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 格式化输出
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// 设置输出编码,默认为UTF-8

			Student stu = new Student();
			stu.setName("Zhangsan");
			stu.setCountry("CN");

			// 指定时间格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			stu.setBirthDate(sdf.format(new Date()));
			marshaller.marshal(stu, xmlFile);
			System.out.println("Obj2Xml Over!");

		} catch (JAXBException e) {
			System.out.println("error");

			System.out.println(e.toString());
			System.out.println(e.getStackTrace());
			// TODO: handle exception
		}
	}
}
