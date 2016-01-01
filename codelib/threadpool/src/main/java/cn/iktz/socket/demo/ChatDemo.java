package cn.iktz.socket.demo;
/*
编写一个聊天程序。

有收数据的部分，和发数据的部分。
这两部分需要同时执行。
那就需要用到多线程技术。
一个线程控制收，一个线程控制发。

因为收和发动作是不一致的，所以要定义两个run方法。
而且这两个方法要封装到不同的类中。
*/
import java.net.DatagramSocket;


class ChatDemo {
	public static void main(String[] args) throws Exception {
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(10002);
		new Thread(new SendRunnable(sendSocket)).start();
		new Thread(new ReceiveRunnable(receSocket)).start();
	}
}
