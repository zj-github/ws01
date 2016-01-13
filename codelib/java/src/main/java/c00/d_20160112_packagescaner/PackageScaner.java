package c00.d_20160112_packagescaner;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @ClassName: PackageScaner 
 * @Description:  
 * @author zhangjie
 * @date 2016��1��12�� ����6:20:37 
 *
 */
/**
 * 
 * 1�������� JarFile 2��classpath�ĸ��� 3��ClassLoader��ȡClassPath
 * 
 */
public class PackageScaner {
	private Logger logger = Logger.getLogger(PackageScaner.class);

	private final String JAR_SUFFIX = ".jar";
	private final String CLASS_SUFFIX = ".jar";

	public static void main(String[] args) {
		// 1����ȡ��ǰ�̵߳�ClassLoader
		// 2��ͨ��ClassLoader��ȡclasspath
		// 3������ClassPath��ȡjar��
		// 4������jar���е�·����ȡ��ָ���İ���
		// 5����ȡָ���İ����µ�class��β���ļ�

	}

	public URLClassLoader getURLClassLoader() {
		return (URLClassLoader) Thread.currentThread().getContextClassLoader();
	}

	public URL[] getClassPath(URLClassLoader urlClassLoader) {
		URL[] urLs = urlClassLoader.getURLs();
		return urLs;
	}

	public void getJarFile(URL[] urls) throws Exception {
		CopyOnWriteArrayList<JarFile> jarFileList = new CopyOnWriteArrayList<>();
		for (URL url : urls) {
			String classPath = url.getPath();//
			// �����jar�ļ�
			if (JAR_SUFFIX.endsWith(classPath)) {
				jarFileList.add(new JarFile(classPath));
			} else if (classPath.indexOf(".") != -1) {// �����Ե��β�����װ��File�����ж��Ƿ����ļ���
				File file = new File(classPath);
				boolean directory = file.isDirectory();
				if (directory) {

				} else {

				}

			}

		}
	}

	/**
	 * 
	 * @Description: ��ȡ�ļ����µ�jarFile
	 * @author zhangjie
	 * @date 2016��1��13�� ����9:35:17
	 * @param dirPath
	 * @throws Exception
	 *
	 */
	public void getJarFilesFromDir(File file, TreeSet<JarFile> jarFileList) throws Exception {
		logger.debug(" scan dir path " + file.getAbsolutePath());
		if (file.isDirectory()) {
			File[] list = file.listFiles();
			for (File f : list) {
				String absolutePath = f.getAbsolutePath();
				logger.debug("    * list path >> " + absolutePath);
				getJarFilesFromDir(new File(absolutePath), jarFileList);
			}
		} else {
			if (file.getName().indexOf(JAR_SUFFIX) != -1) {
				logger.debug(" scan dir path " + file.getAbsolutePath());
				if (jarFileList.add(new JarFile(file))) {
					logger.info("add jar file " + file.toPath());
				}
			}
		}
	}

	@Test
	public void getJarFilesFromDirtest() {
		TreeSet<JarFile> jarFileList = new TreeSet<>();
		try {
			getJarFilesFromDir(new File("E:\\devsf\\java\\jdk1.7.0_51"), jarFileList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(jarFileList.toArray()));
	}

	public void getSpePackage(TreeSet<JarFile> jarFileList) {
	}

	public void getClassesFromJarFile(JarFile jarFile, String packageName,TreeSet<String> classList) {
		Enumeration<JarEntry> entries = jarFile.entries();
		while (entries.hasMoreElements()) {
			JarEntry jarEntry = entries.nextElement();
			String name = jarEntry.getName();
			packageName = packageName.replace(".", File.pathSeparator);
			if (!jarEntry.isDirectory() && name.startsWith(packageName) && name.endsWith(CLASS_SUFFIX)
					&& name.indexOf("$") == -1) {
				classList.add(name);
			}
		}
	}
}
