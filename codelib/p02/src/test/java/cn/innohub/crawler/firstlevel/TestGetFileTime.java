package cn.innohub.crawler.firstlevel;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import cn.innohub.crawler.common.utils.Path;

public class TestGetFileTime {

	public static void main(String[] args) {

	}

	@Test
	public void test01() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String path = "G:\\网页更新相关的标签.docx";
//		String path = "G:\\seeds.xml";
		String path = Path.getClassPath() + "seeds.xml";
		System.out.println(path);
		File file = new File(path);
		// 毫秒数
		System.out.println(format.format(new Date(file.lastModified())));
	}

	@Test
	public void test02() {
		try {
			String path = Path.getClassPath() + "seeds.xml";
			System.out.println(path);
			Process p = Runtime.getRuntime().exec("dir "+path+" /tc");
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str;
			int i = 0;
			while ((str = br.readLine()) != null) {
				i++;
				System.out.println(str+" >> "+i);
				
//				if (i == 6) {
//					System.out.println(str.substring(0, 17));
//				}
			}

		} catch (java.io.IOException exc) {
			exc.printStackTrace();
		}
	}

}