package cn.iktz.thread.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public interface Future<V> {
	//取消执行的任务
    boolean cancel(boolean mayInterruptIfRunning);
    //如果任务在未完成之前取消，则返回true
    boolean isCancelled();
    //任务完成，返回true
    boolean isDone();
    //	等待返回的结果
    V get() throws InterruptedException, ExecutionException;
    //按照指定的时间去获取执行的结果，
    V get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException;
}