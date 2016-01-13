package c00.d_20160112_packagescaner;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassUtils2 {
	public static void main(String[] args) throws Exception {
		String packageName = "cn.innohub.web.project.a05_mvcframe.test.t1";
		Set<String> classNames = getClassName(packageName, true);
		if (classNames != null) {
			for (String className : classNames) {
				System.out.println(className);
			}
		}
	}

	/**
	 * ��ȡĳ����������
	 * 
	 * @param packageName
	 *            ����
	 * @param isRecursion
	 *            �Ƿ�����Ӱ�
	 * @return �����������
	 */
	public static Set<String> getClassName(String packageName, boolean isRecursion) {
		Set<String> classNames = null;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String packagePath = packageName.replace(".", "/");
		System.out.println(" package path : " + packagePath);
		/* �����е�jar���в��Ұ��� */
		classNames = getClassNameFromJars(((URLClassLoader) loader).getURLs(), packageName, isRecursion);

		return classNames;
	}

	public static Set<String> getClassName1(String packageName, boolean isRecursion) {
		Set<String> classNames = null;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String packagePath = packageName.replace(".", "/");
		System.out.println(" package path : " + packagePath);
		URL url = loader.getResource(packagePath);
		if (url != null) {
			System.out.println("url is not null");
			String protocol = url.getProtocol();
			if (protocol.equals("file")) {
				classNames = getClassNameFromDir(url.getPath(), packageName, isRecursion);
			} else if (protocol.equals("jar")) {
				JarFile jarFile = null;
				try {
					jarFile = ((JarURLConnection) url.openConnection()).getJarFile();
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (jarFile != null) {
					getClassNameFromJar(jarFile.entries(), packageName, isRecursion);
				}
			}
		} else {
			/* �����е�jar���в��Ұ��� */
			System.out.println("find package from jar");
			classNames = getClassNameFromJars(((URLClassLoader) loader).getURLs(), packageName, isRecursion);
		}

		return classNames;
	}

	/**
	 * ����Ŀ�ļ���ȡĳ����������
	 * 
	 * @param filePath
	 *            �ļ�·��
	 * @param className
	 *            ��������
	 * @param isRecursion
	 *            �Ƿ�����Ӱ�
	 * @return �����������
	 */
	private static Set<String> getClassNameFromDir(String filePath, String packageName, boolean isRecursion) {
		Set<String> className = new HashSet<String>();
		File file = new File(filePath);
		File[] files = file.listFiles();
		for (File childFile : files) {
			if (childFile.isDirectory()) {
				if (isRecursion) {
					String path = childFile.getPath();
					className.addAll(getClassNameFromDir(path, packageName + "." + childFile.getName(),
							isRecursion));
				}
			} else {
				String fileName = childFile.getName();
				if (fileName.endsWith(".class") && !fileName.contains("$")) {
					className.add(packageName + "." + fileName.replace(".class", ""));
				}
			}
		}

		return className;
	}

	/**
	 * @param jarEntries
	 * @param packageName
	 * @param isRecursion
	 * @return
	 */
	private static Set<String> getClassNameFromJar(Enumeration<JarEntry> jarEntries, String packageName,
			boolean isRecursion) {
		Set<String> classNames = new HashSet<String>();

		while (jarEntries.hasMoreElements()) {
			JarEntry jarEntry = jarEntries.nextElement();
			if (!jarEntry.isDirectory()) {
				/*
				 * ������Ϊ�˷��㣬�Ȱ�"/" ת�� "." ���ж� ".class" ���������ܻ���bug (FIXME: �Ȱ�"/" ת��
				 * "." ���ж� ".class" ���������ܻ���bug)
				 */
				String entryName = jarEntry.getName().replace("/", ".");
				if (entryName.endsWith(".class") && !entryName.contains("$") && entryName.startsWith(packageName)) {
					entryName = entryName.replace(".class", "");
					if (isRecursion) {
						classNames.add(entryName);
					} else if (!entryName.replace(packageName + ".", "").contains(".")) {
						classNames.add(entryName);
					}
				}
			}
		}

		return classNames;
	}

	/**
	 * ������jar�������ð�������ȡ�ð���������
	 * 
	 * @param urls
	 *            URL����
	 * @param packageName
	 *            ��·��
	 * @param isRecursion
	 *            �Ƿ�����Ӱ�
	 * @return �����������
	 */
	private static Set<String> getClassNameFromJars(URL[] urls, String packageName, boolean isRecursion) {
		Set<String> classNames = new HashSet<String>();

		for (int i = 0; i < urls.length; i++) {
			String classPath = urls[i].getPath();

			// ��������classes�ļ���
			if (classPath.endsWith("classes/")) {
				continue;
			}

			JarFile jarFile = null;
			try {
				String jarFilePath = classPath.substring(classPath.indexOf("/"));
				System.out.println("jar file path : " + jarFilePath);
				jarFile = new JarFile(jarFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (jarFile != null) {
				System.out.println("jar file is not null");
				classNames.addAll(getClassNameFromJar(jarFile.entries(), packageName, isRecursion));
			} else {
				System.out.println("jar file is null");
			}
		}

		return classNames;
	}
}