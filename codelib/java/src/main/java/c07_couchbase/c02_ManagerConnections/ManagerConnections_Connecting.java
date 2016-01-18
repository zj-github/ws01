package c07_couchbase.c02_ManagerConnections;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

public class ManagerConnections_Connecting {
	// Managing connections
	//
	// This section covers the different approaches to connecting and
	// disconnecting, as well as how to configure
	// encryption.�ⲿ�ְ�����������Ӻ��ͷ����ӵķ������������ü���

	// Connecting
	// Connecting to a bucket is a two-step process: first, a CouchbaseCluster
	// object needs to be initialized, followed by one or more calls to
	// openBucket():
	/**
	 * ���ӵ�һ��Ͱ��2������ 1����ʼ��һ��CouchbaseCluster���� 2������openBucket����
	 */
	// If no further arguments are applied, this code connects to localhost and
	// opens the default bucket. While this is suitable for development, you
	// most probably want to connect to a remote cluster and also a different
	// bucket (with a password):
	@Test
	public void connecting01() {
		Cluster cluster = CouchbaseCluster.create();
		Bucket bucket = cluster.openBucket();
	}

	@Test
	public void connecting02() {
		Cluster cluster = CouchbaseCluster.create("192.168.56.101", "192.168.56.102");
		Bucket bucket = cluster.openBucket("myapp", "password");
	}

	// Alternatively�����⣩, a list of nodes can be passed in:
	@Test
	public void connecting03() {
		List<String> nodes = Arrays.asList("192.168.56.101", "192.168.56.102");
		Cluster cluster = CouchbaseCluster.create(nodes);
	}

	// It is very important in a production setup to pass in at least two or
	// three nodes of the cluster because if the first one in the list fails the
	// other ones can be tried. After initial contact is made, the bootstrap
	// list provided by the user is thrown away and replaced with a list
	// provided by the server (which contains all nodes of the cluster).
	//
	// More buckets can be open at the same time if needed:
	@Test
	public void connecting04() {
		Cluster cluster = CouchbaseCluster.create("192.168.56.101", "192.168.56.102");
		Bucket bucket1 = cluster.openBucket("bucket1", "password");
		Bucket bucket2 = cluster.openBucket("bucket2", "password");
	}

	// If more than one bucket is open at a time, the underlying core-io module
	// makes sure to utilize�����ã� the resources as best as possible, that is
	// sharing
	// sockets, thread pools and so on.

	/*
	 * Here are some very important things to keep in mind:
	 * 
	 * Always create only one instance of a CouchbaseCluster and share it across
	 * threads (same with buckets). The SDK is thread-safe, so no additional
	 * synchronization is needed when interacting with the SDK. If different
	 * clusters need to be accessed, reuse the ClusterEnvironment.
	 */
	/**
	 * ��Ҫ�μ����ĵ����� 1�����Ǵ���һ��CouchbaseCluster��buckets��ʵ�����ж��̣߳�����Щ�̹߳������ǡ�
	 * 2��sdk���̰߳�ȫ�ģ�����Ҫ�����ͬ������������໥���á� 3�������Ҫ���ʲ�ͬ�ļ�Ⱥ������ClusterEnvironment
	 */

	// If the underlying environment is not shared the application will continue
	// to work, but a warning is raised in the logs:
	/**
	 * ���û�й���ײ�� environment ��Ӧ�ý��������У����ǻ��׳�����WARNING: More than 1 Couchbase
	 * Environments found (N), this can have severe impact on performance and
	 * stability. Reuse environments!
	 */
	// In general, this is an indication��ָʾ�� of misconfiguration����������ã�, the
	// only exception
	// being unit and integration�����ϣ� tests where multiple paths are executed at
	// once and cannot share the ClusterEnvironment for whatever reason.
	/**
	 * ͨ�������������˴��������
	 * ��Щ�쳣�������Գ����ڶ�·���ĵ�Ԫ���ԡ��������ϲ����в���ֻ����һ�Ρ�ԭ���ܹ���ClusterEnvironment��
	 */

}
