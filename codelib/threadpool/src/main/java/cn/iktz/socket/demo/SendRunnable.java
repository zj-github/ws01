package cn.iktz.socket.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendRunnable implements Runnable {
	private DatagramSocket ds;

	public SendRunnable(DatagramSocket ds) {
		this.ds = ds;
	}

	public void run() {
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while ((line = bufr.readLine()) != null) {
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.1.255"), 10002);
				ds.send(dp);
				if ("886".equals(line))
					break;
			}
		} catch (Exception e) {
			throw new RuntimeException("发送端失败");
		}
	}
}
