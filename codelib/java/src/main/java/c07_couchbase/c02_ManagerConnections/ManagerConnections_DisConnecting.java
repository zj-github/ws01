package c07_couchbase.c02_ManagerConnections;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

public class ManagerConnections_DisConnecting {

	// The most common case is to disconnect the whole CouchbaseCluster from the
	// server, which has the same effect as closing all buckets manually and in
	// addition close all underlying resources like thread pools. This also
	// means that once disconnect has happened, you can't reopen buckets from
	// the same Cluster instance.

	/**
	 * 最常用的方案是断开整个CouchbaseCluster的连接。这种方法也关闭了所有的地城资源，如线程。 这也意味着 你不能在这个实例上打开桶了。
	 */

	public void colse() {
		Cluster cluster = CouchbaseCluster.create();
		Boolean disconnected = cluster.disconnect();
	}

	// If the ClusterEnvironment is shared it needs to be closed manually, but
	// if not (which is the regular case) it gets also shut down.

}
