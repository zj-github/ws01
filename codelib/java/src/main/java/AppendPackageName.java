import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.junit.Test;

public class AppendPackageName {

	public static void main(String[] args) throws Exception {
		String path = "E:\\ws\\JaveSE\\src";

		File file = new File(path);
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for (File f : listFiles) {
				String name = f.getName();
				if (f.isDirectory()) {

					for (File f2 : f.listFiles()) {

						String name2 = f2.getName();
						if (name2.endsWith(".java")) {
							System.out.println(name2);
							BufferedReader br = new BufferedReader(new FileReader(f2));
							StringBuilder sb = new StringBuilder();
							String line = "";
							System.out.println(f.getName());
							sb.append("package "+f.getName()+";\n");
							while ((line = br.readLine()) != null) {
								if(!line.startsWith("package")){
									sb.append(line+"\n");
								}
								//System.out.println(line);
							}
							BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
							bw.write(sb.toString());
							bw.flush();
						}

					}
				}

				System.out.println(name);
			}
		}
	}
	@Test
	public void test02(){
		String path = "E:\\ws\\JaveSE\\src";
		File file = new File(path);
		System.out.println(file.getName());
		System.out.println(file.getParent());
		
	}
}
