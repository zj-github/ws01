package c04_crawler.jdk;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

public class Test01 {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:8080/TestHttpURLConnectionPro/index.jsp");

		URLConnection rulConnection = url.openConnection();// 此处的urlConnection对象实际上是根据URL�?
		// 请求协议(此处是http)生成的URLConnection�?
		// 的子类HttpURLConnection,故此处最好将其转�?
		// 为HttpURLConnection类型的对�?以便用到
		// HttpURLConnection更多的API.如下:

		HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;

		// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
		// http正文内，因此�?��设为true, 默认情况下是false;
		httpUrlConnection.setDoOutput(true);

		// 设置是否从httpUrlConnection读入，默认情况下是true;
		httpUrlConnection.setDoInput(true);

		// Post 请求不能使用缓存
		httpUrlConnection.setUseCaches(false);

		// 设定传�?的内容类型是可序列化的java对象
		// (如果不设此项,在传送序列化对象�?当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
		httpUrlConnection.setRequestProperty("Content-type", "application/x-java-serialized-object");

		// 设定请求的方法为"POST"，默认是GET
		httpUrlConnection.setRequestMethod("POST");

		// 连接，从上述�?条中url.openConnection()至此的配置必须要在connect之前完成�?
		httpUrlConnection.connect();

		// 此处getOutputStream会隐含的进行connect(即：如同调用上面的connect()方法�?
		// �?��在开发中不调用上述的connect()也可�?�?
		OutputStream outStrm = httpUrlConnection.getOutputStream();

		// 现在通过输出流对象构建对象输出流对象，以实现输出可序列化的对象�?
		ObjectOutputStream objOutputStrm = new ObjectOutputStream(outStrm);

		// 向对象输出流写出数据，这些数据将存到内存缓冲区中
		objOutputStrm.writeObject(new String("我是测试数据"));

		// 刷新对象输出流，将任何字节都写入潜在的流中（些处为ObjectOutputStream�?
		objOutputStrm.flush();

		// 关闭流对象�?此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区�?
		// 在调用下边的getInputStream()函数时才把准备好的http请求正式发�?到服务器
		objOutputStrm.close();

		// 调用HttpURLConnection连接对象的getInputStream()函数,
		// 将内存缓冲区中封装好的完整的HTTP请求电文发�?到服务端�?
		InputStream inStrm = httpUrlConnection.getInputStream(); // <===注意，实际发送请求的代码段就在这�?
		inStrm.close();
		// 上边的httpConn.getInputStream()方法已调�?本次HTTP请求已结�?下边向对象输出流的输出已无意义，
		// 既使对象输出流没有调用close()方法，下边的操作也不会向对象输出流写入任何数�?
		// 因此，要重新发�?数据时需要重新创建连接�?重新设参数�?重新创建流对象�?重新写数据�?
		// 重新发�?数据(至于是否不用重新这些操作�?��再研�?
		objOutputStrm.writeObject(new String(""));
		httpUrlConnection.getInputStream();

	}

	@Test
	public void test01() throws Exception {
		URL url = new URL("https://www.baidu.com");
		URLConnection rulConnection = url.openConnection();
		HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
		httpUrlConnection.setDoOutput(true);
		httpUrlConnection.setDoInput(true);
		httpUrlConnection.setUseCaches(false);
		httpUrlConnection.setRequestProperty("Content-type", "application/x-java-serialized-object");
		// httpUrlConnection.setRequestMethod("POST");
		httpUrlConnection.connect();

		// OutputStream outStrm = httpUrlConnection.getOutputStream();
		// ObjectOutputStream objOutputStrm = new ObjectOutputStream(outStrm);
		// objOutputStrm.writeObject(new String("我是测试数据"));
		// objOutputStrm.flush();
		// objOutputStrm.close();
		BufferedReader is = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));
		String line = "";
		while ((line = is.readLine()) != null) {
			System.out.println(line);
		}

	}
}
