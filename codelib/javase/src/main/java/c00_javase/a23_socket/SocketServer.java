package c00_javase.a23_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketServer {
	public static boolean shutdown = false;

	public void accept() throws Exception {

		int threadNum = 5; // 抓取线程数
		ExecutorService fetchThreadPool = Executors.newFixedThreadPool(threadNum);

		ServerSocket ss = new ServerSocket(10005);
		try {
			while (!shutdown) {
				Socket s = ss.accept();
				fetchThreadPool.submit(new ControlTask(s));
			}
		} finally {
			if (ss != null) {
				ss.close();
			}
		}
	}

	// 加载
	// detail-seed.properties
	// fields-extract-reg.xml
	// first-level-seeds.xml

	class ControlTask implements Runnable {
		private Socket s = null;

		public ControlTask(Socket s) {
			this.s = s;
		}

		@Override
		public void run() {
			try {
				String ip = s.getInetAddress().getHostAddress();
				System.out.println(ip + "....connected");
				BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String line = bufIn.readLine();

				System.out.println(line);
				// 反射调用方法
				invoke(line);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (s != null) {
					try {
						s.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 
	 * @Description: 反射调用放发
	 * @author zhangjie
	 * @date 2016年1月6日 下午1:33:38
	 *
	 */
	public void invoke(String str) {
		String[] s = parse(str);
		String clazzName = s[0];
		String methodName = s[1];
		try {
			Object oins = Class.forName(clazzName).newInstance();
			Class<?> clazz = Class.forName(clazzName);
			Method method = clazz.getMethod(methodName, new Class<?>[0]);
			method.invoke(oins, new Object[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String[] parse(String str) {
		String[] s = new String[2];
		int lastPointIndex = str.lastIndexOf(".");
		s[1] = str.substring(lastPointIndex + 1);
		s[0] = str.substring(0, lastPointIndex);
		return s;
	}
}