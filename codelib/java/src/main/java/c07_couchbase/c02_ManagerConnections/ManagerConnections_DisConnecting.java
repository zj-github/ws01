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
	 * ��õķ����ǶϿ�����CouchbaseCluster�����ӡ����ַ���Ҳ�ر������еĵس���Դ�����̡߳� ��Ҳ��ζ�� �㲻�������ʵ���ϴ�Ͱ�ˡ�
	 */

	public void colse() {
		Cluster cluster = CouchbaseCluster.create();
		Boolean disconnected = cluster.disconnect();
	}

	// If the ClusterEnvironment is shared it needs to be closed manually, but
	// if not (which is the regular case) it gets also shut down.

}
