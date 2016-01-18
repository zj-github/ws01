package c07_couchbase.c02_ManagerConnections;

import com.couchbase.client.java.AsyncBucket;
import com.couchbase.client.java.AsyncCluster;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseAsyncCluster;
import com.couchbase.client.java.CouchbaseCluster;

import rx.Observable;

public class ManagerConnections_ConnectingAsynchronously {

	// Connecting Asynchronously
	// Every synchronous API is just a wrapper around an asynchronous one. To
	// get to it, you can use one of these methods:
	/**
	 * 所有的同步接口都是 包装了同步方法的。 你可以用这些方法来得到他们
	 */

	// Use async() on the interface to access its Async* counterpart（对应）.
	// Instantiate（实例化） a CouchbaseAsyncCluster in the first place.
	/**
	 * 1、使用同步接口上的async()方法访问的同步类 2、在开始的地方实例化一个CouchbaseAsyncCluster对象
	 */

	// So if you are connecting to the bucket synchronously but then want to
	// switch over to asynchronous data operations, you can do it like this:

	/**
	 * 如果你连接到一个同步的桶，但是想切换到异步，来操作数据，可以这样做
	 */
	public void tst01() {
		Cluster cluster = CouchbaseCluster.create();
		Bucket bucket = cluster.openBucket();

		// Same API as Bucket, but completely async with Observables
		AsyncBucket asyncBucket = bucket.async();

	}

	// On the other hand, you can use the Async API right from the beginning:
	/**
	 * 或者你一开始就是用异步的api
	 */
	public void tst02() {
		AsyncCluster cluster = CouchbaseAsyncCluster.create();
		Observable<AsyncBucket> bucketObservable = cluster.openBucket();
	}
	

}
