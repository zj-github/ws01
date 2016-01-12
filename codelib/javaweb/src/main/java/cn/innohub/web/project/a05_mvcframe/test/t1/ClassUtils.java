//package cn.innohub.web.project.a05_mvcframe.test.t1;
//
//import java.io.IOException;
//import java.net.URL;
//import java.net.URLClassLoader;
//import java.util.Enumeration;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.jar.JarEntry;
//import java.util.jar.JarFile;
//
//public class ClassUtils {
//	public static void main(String[] args) throws Exception {
//		String packageName = "cn.innohub.web.project.a05_mvcframe.test.t1";
//		Set<String> classNames = getClassName(packageName, true);
//		if (classNames != null) {
//			for (String className : classNames) {
//				System.out.println(className);
//			}
//		}
//	}
//
//	public static Set<String> getClassName(String packageName, boolean isRecursion) {
//		Set<String> classNames = null;
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//		String packagePath = packageName.replace(".", "/");
//		System.out.println(" package path : " + packagePath);
//		classNames = getClassNameFromJars(((URLClassLoader) loader).getURLs(), packageName, isRecursion);
//		return classNames;
//	}
//
//	private static Set<String> getClassNameFromJar(Enumeration<JarEntry> jarEntries, String packageName,
//			boolean isRecursion) {
//		Set<String> classNames = new HashSet<String>();
//
//		while (jarEntries.hasMoreElements()) {
//			JarEntry jarEntry = jarEntries.nextElement();
//			if (!jarEntry.isDirectory()) {
//				/*
//				 * 这里是为了方便，先把"/" 转成 "." 再判断 ".class" 的做法可能会有bug (FIXME: 先把"/" 转成
//				 * "." 再判断 ".class" 的做法可能会有bug)
//				 */
//				String entryName = jarEntry.getName().replace("/", ".");
//				if (entryName.endsWith(".class") && !entryName.contains("$") && entryName.startsWith(packageName)) {
//					entryName = entryName.replace(".class", "");
//					if (isRecursion) {
//						classNames.add(entryName);
//					} else if (!entryName.replace(packageName + ".", "").contains(".")) {
//						classNames.add(entryName);
//					}
//				}
//			}
//		}
//
//		return classNames;
//	}
//
//	/**
//	 * 从所有jar中搜索该包，并获取该包下所有类
//	 * 
//	 * @param urls
//	 *            URL集合
//	 * @param packageName
//	 *            包路径
//	 * @param isRecursion
//	 *            是否遍历子包
//	 * @return 类的完整名称
//	 */
//	private static Set<String> getClassNameFromJars(URL[] urls, String packageName, boolean isRecursion) {
//		Set<String> classNames = new HashSet<String>();
//
//		for (int i = 0; i < urls.length; i++) {
//			String classPath = urls[i].getPath();// 1、获取classpath路径
//			//如果是目录
//			if(){
//				
//			}
//			
//			JarFile jarFile = null;
//			try {
//				jarFile = new JarFile(classPath);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			if (jarFile != null) {
//				System.out.println("jar file is not null");
//				classNames.addAll(getClassNameFromJar(jarFile.entries(), packageName, isRecursion));
//			} else {
//				System.out.println("jar file is null");
//			}
//		}
//
//		return classNames;
//	}
//}