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
	 * ���е�ͬ���ӿڶ��� ��װ��ͬ�������ġ� ���������Щ�������õ�����
	 */

	// Use async() on the interface to access its Async* counterpart����Ӧ��.
	// Instantiate��ʵ������ a CouchbaseAsyncCluster in the first place.
	/**
	 * 1��ʹ��ͬ���ӿ��ϵ�async()�������ʵ�ͬ���� 2���ڿ�ʼ�ĵط�ʵ����һ��CouchbaseAsyncCluster����
	 */

	// So if you are connecting to the bucket synchronously but then want to
	// switch over to asynchronous data operations, you can do it like this:

	/**
	 * ��������ӵ�һ��ͬ����Ͱ���������л����첽�����������ݣ�����������
	 */
	public void tst01() {
		Cluster cluster = CouchbaseCluster.create();
		Bucket bucket = cluster.openBucket();

		// Same API as Bucket, but completely async with Observables
		AsyncBucket asyncBucket = bucket.async();

	}

	// On the other hand, you can use the Async API right from the beginning:
	/**
	 * ������һ��ʼ�������첽��api
	 */
	public void tst02() {
		AsyncCluster cluster = CouchbaseAsyncCluster.create();
		Observable<AsyncBucket> bucketObservable = cluster.openBucket();
	}
	

}
