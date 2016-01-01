package cn.iktz.thread.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface Future<V> {
	//ȡ��ִ�е�����
    boolean cancel(boolean mayInterruptIfRunning);
    //���������δ���֮ǰȡ�����򷵻�true
    boolean isCancelled();
    //������ɣ�����true
    boolean isDone();
    //	�ȴ����صĽ��
    V get() throws InterruptedException, ExecutionException;
    //����ָ����ʱ��ȥ��ȡִ�еĽ����
    V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}