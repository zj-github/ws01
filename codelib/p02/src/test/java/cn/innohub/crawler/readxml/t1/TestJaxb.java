package cn.innohub.crawler.readxml.t1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.junit.Test;

import cn.innohub.crawler.common.utils.Path;

public class TestJaxb {

	@Test
	public void beanToXML() {
		Classroom classroom = new Classroom(1, "软件工程", 4);
		Student student = new Student(101, "张三", 22, classroom);

		try {
			JAXBContext context = JAXBContext.newInstance(Student.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(student, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void XMLStringToBean() throws Exception{
		try {
			JAXBContext context = JAXBContext.newInstance(Student.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
//			StringReader reader = new StringReader(xmlStr);
			String xmlFilePath = Path.getClassPath() + "NewFile.xml";
			FileReader reader = new FileReader(new File(xmlFilePath));
			
			Student student = (Student)unmarshaller.unmarshal(reader);
			System.out.println(student.getAge());
			System.out.println(student.getClassroom().getName());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void XMLStringToBean2() throws Exception{
		try {
			JAXBContext context = JAXBContext.newInstance(CrawlInfo.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			String xmlFilePath = Path.getClassPath() + "NewFile.xml";
			FileReader reader = new FileReader(new File(xmlFilePath));
			
			CrawlInfo crawlInfo = (CrawlInfo)unmarshaller.unmarshal(reader);
			Arrays.toString(crawlInfo.getDetailTypes().toArray());
//			Map<String, DetailType> detailTypes = crawlInfo.getDetailTypes();
//			Set<Entry<String, DetailType>> entrySet = detailTypes.entrySet();
//			for(Entry<String, DetailType> d:entrySet){
//				System.out.println(d.getKey());
//			}
			System.out.println(crawlInfo);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
}
