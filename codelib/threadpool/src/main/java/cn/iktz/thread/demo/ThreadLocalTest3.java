package cn.iktz.thread.demo;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalTest3 {

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + " has put data :" + data);
					MyThreadScopeData.getThreadInstance().setName("name" + data);
					MyThreadScopeData.getThreadInstance().setAge(data);
					new A().get();
				}
			}).start();
		}
	}

	static class A {
		public void get() {
			MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
			System.out.println("A from " + Thread.currentThread().getName() + " getMyData: " + myData.getName() + ","
					+ myData.getAge());
		}
	}

	static class MyThreadScopeData {
		private MyThreadScopeData() {
		}

		static Lock lock = new ReentrantLock();
		public static MyThreadScopeData getThreadInstance() {
			lock.lock();
			try {
				MyThreadScopeData instance = map.get();
				if (instance == null) {
					instance = new MyThreadScopeData();
					/**
					 ������ܻ���ֲ������⣬����Ҫ������
					 
					 �������a�̴߳����˶��󣬲���ֵ����ʱinstanceָ��0X6666��
					 Ȼ��b����getΪnull��Ҳ�ᴴ��һ�����󲢸�ֵ����ʱinstanceָ��0x7777��0x6666������
					 b�̷߳�����0x7777�Ķ��󣬴�ʱ�л���a�̣߳�aҲ�����0x7777�Ķ�������ֲ�������
					 */
					map.set(instance);
				}
				return instance;
			} finally{
				lock.unlock();
			}
		}

		private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
		private String name;
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}
