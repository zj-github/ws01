package cn.innohub.web.project.a05_mvcframe.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

/**
 * @ClassName: PackageScaner 
 * @Description:  
 * @author zhangjie
 * @date 2016年1月12日 下午6:20:37 
 *
 */
/**
 * 
 * 1、工具类 JarFile 2、classpath的概念 3、ClassLoader获取ClassPath
 */
public class PackageScaner {
	
	public static void main(String[] args) throws Exception {
		new PackageScaner().scan("cn.innohub.web.project.a05_mvcframe.utils");
		
	}
	private Logger logger = Logger.getLogger(PackageScaner.class);

	public TreeSet<String> scan(String packageName) throws Exception {
		System.out.println("------ start scan ---------");
		PackageScaner pscaner = new PackageScaner();
		// 1、获取当前线程的ClassLoader
		URLClassLoader urlClassLoader = pscaner.getURLClassLoader();
		// 2、通过ClassLoader获取classpath
		URL[] classPathes = pscaner.getClassPath(urlClassLoader);
		for (URL url : classPathes) {
			File file = new File(url.toURI());
			if(file.isDirectory()){
				
			}
			System.out.println(" class path >> "+url.toURI());
		}
		
		// 3、遍历ClassPath获取jar包
		TreeSet<String> jarFile = pscaner.getJarFile(classPathes);
		for (String string : jarFile) {
			System.out.println(" >> jar file " + string);
		}
		// 4、遍历jar包中的路径，取得指定的包名下的class文件
		System.out.println(" package name is " + packageName);
		TreeSet<String> classes = pscaner.getSpePackageClass(jarFile, packageName);
		return classes;
	}

	private final String JAR_SUFFIX = ".jar";
	private final String CLASS_SUFFIX = ".class";

	private URLClassLoader getURLClassLoader() {
		return (URLClassLoader) Thread.currentThread().getContextClassLoader();
	}

	private URL[] getClassPath(URLClassLoader urlClassLoader) {
		URL[] urLs = urlClassLoader.getURLs();
		return urLs;
	}

	private TreeSet<String> getJarFile(URL[] urls) throws Exception {
		TreeSet<String> jarFiles = new TreeSet<>();
		for (URL url : urls) {
			jarFiles.addAll(getJarFilesFromDir(url.getPath()));
		}
		return jarFiles;
	}

	/**
	 * 
	 * @Description: 获取文件夹下的jarFile
	 * @author zhangjie
	 * @date 2016年1月13日 上午9:35:17
	 * @param dirPath
	 * @throws Exception
	 *
	 */
	private void getJarFilesFromDir(File file, TreeSet<String> jarFileList) {
		try {
			logger.debug(" scan dir path " + file.getAbsolutePath());
			if (file.isDirectory()) {
				File[] list = file.listFiles();
				for (File f : list) {
					String absolutePath = f.getAbsolutePath();
					System.out.println("    * list path >> " + absolutePath);
					logger.debug("    * list path >> " + absolutePath);
					getJarFilesFromDir(new File(absolutePath), jarFileList);
				}
			} else {
				if (file.getName().indexOf(JAR_SUFFIX) != -1) {
					logger.debug(" scan dir path " + file.getAbsolutePath());
					if (jarFileList.add(file.getAbsolutePath())) {
						logger.debug("add jar file " + file.toPath());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Description: 获取指定目录下的所有的class
	 * @author zhangjie
	 * @date 2016年1月13日 下午2:48:22
	 * @param dir
	 * @param packageName
	 * @return
	 *
	 */
	private TreeSet<String> getJarFilesFromDir(String dir) {
		TreeSet<String> jarFileList = new TreeSet<>();
		getJarFilesFromDir(new File(dir), jarFileList);
		return jarFileList;
	}

	private TreeSet<String> getSpePackageClass(TreeSet<String> jarFileList, String packageName) {
		TreeSet<String> classList = new TreeSet<>();
		for (String jarFilePath : jarFileList) {

			getClassesFromJarFile(jarFilePath, packageName, classList);
		}
		return classList;
	}

	private void getClassesFromJarFile(String jarFilePath, String packageName, TreeSet<String> classList) {
		JarFile jarFile = null;
		try {
			jarFile = new JarFile(jarFilePath);

			Enumeration<JarEntry> entries = jarFile.entries();
			while (entries.hasMoreElements()) {
				JarEntry jarEntry = entries.nextElement();
				String name = jarEntry.getName();
				packageName = packageName.replace(".", "/");
				if (!jarEntry.isDirectory() && name.startsWith(packageName) && name.endsWith(CLASS_SUFFIX)
						&& name.indexOf("$") == -1) {
					classList.add(name.replace("/", ".").replace(".class", ""));
					logger.info("-- " + name);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (jarFile != null) {
				try {
					jarFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
