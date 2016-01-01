package cn.iktz.socket.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveRunnable implements Runnable {

	private DatagramSocket ds;

	public ReceiveRunnable(DatagramSocket ds) {
		this.ds = ds;
	}

	public void run() {
		try {
			while (true) {
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(), 0, dp.getLength());
				if ("886".equals(data)) {
					System.out.println(ip + "....离开聊天室");
					break;
				}
				System.out.println(ip + ":" + data);
			}
		} catch (Exception e) {
			throw new RuntimeException("接收端失败");
		}
	}
}