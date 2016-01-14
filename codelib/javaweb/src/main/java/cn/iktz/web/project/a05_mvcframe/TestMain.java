package cn.iktz.web.project.a05_mvcframe;

public class TestMain {

	public static void main(String[] args) throws Exception {
		String xml = "cn/innohub/web/project/a05_mvcframe/mvc.xml";
		String path = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath()+xml;
		MVCContext fromXML = XmlUtil.fromXML(path,MVCContext.class);
		System.out.println(fromXML);
		
	}
}
