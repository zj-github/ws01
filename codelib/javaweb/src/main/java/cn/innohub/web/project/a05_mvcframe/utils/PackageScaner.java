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
			System.out.println(" class path >> " + url.toURI());
		}
		// 3、若ClassPath是目录，遍历获取jar
		// 若是jar，遍历jar包中的路径，取得指定的包名下的class文件
		TreeSet<String> classes = pscaner.getClassesInSpePackage(classPathes,packageName);
		for (String string : classes) {
			System.out.println(" >>  " + string);
		}
	
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

	private TreeSet<String> getClassesInSpePackage(URL[] urls,String packageName) throws Exception {
		String packageDirPath = packageName.replace(".", File.separator);
		TreeSet<String> classNameSet = new TreeSet<>(); 
		for (URL url : urls) {
			File classPath = new File(url.getPath());
			if(classPath.isDirectory()&&classPath.exists()){
				File packageDir = new File(classPath,packageDirPath);
				if(packageDir.isDirectory()&&classPath.exists()){
					getClassesFromPackageDir(packageDir, classPath, classNameSet);
				}
			}else if(classPath.getName().endsWith(JAR_SUFFIX)){
				getClassesFromJarFile(url.getPath(),packageDirPath,classNameSet);
			}
		}
		return classNameSet;
	}

	private void getClassesFromJarFile(String jarFilePath, String packageDir, TreeSet<String> classList) {
		JarFile jarFile = null;
		try {
			jarFile = new JarFile(jarFilePath);

			Enumeration<JarEntry> entries = jarFile.entries();
			while (entries.hasMoreElements()) {
				JarEntry jarEntry = entries.nextElement();
				String name = jarEntry.getName();
				if (!jarEntry.isDirectory() && name.startsWith(packageDir) && name.endsWith(CLASS_SUFFIX)
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

	private void getClassesFromPackageDir(File f,  File classPath, TreeSet<String> classNameSet) {
		if (f.isDirectory()) {
			for (File f2 : f.listFiles()) {
				getClassesFromPackageDir(f2, classPath,classNameSet);
			}
		}else{
			classNameSet.add(f.getAbsolutePath().substring(classPath.getAbsolutePath().length()+1).replace(File.separator,"." ).replace(CLASS_SUFFIX, ""));
		}
	}
	
}
