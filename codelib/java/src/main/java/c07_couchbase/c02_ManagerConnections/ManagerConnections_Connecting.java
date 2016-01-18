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
	// encryption.这部分包含了如何连接和释放连接的方法，还有配置加密

	// Connecting
	// Connecting to a bucket is a two-step process: first, a CouchbaseCluster
	// object needs to be initialized, followed by one or more calls to
	// openBucket():
	/**
	 * 连接到一个桶有2个步骤 1、初始化一个CouchbaseCluster对象 2、调用openBucket方法
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

	// Alternatively（另外）, a list of nodes can be passed in:
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
	// makes sure to utilize（利用） the resources as best as possible, that is
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
	 * 需要牢记在心的事情 1、总是创建一个CouchbaseCluster、buckets的实例，有多线程，则这些线程共享他们。
	 * 2、sdk是线程安全的，不需要额外的同步，否则可能相互作用。 3、如果需要访问不同的集群，重用ClusterEnvironment
	 */

	// If the underlying environment is not shared the application will continue
	// to work, but a warning is raised in the logs:
	/**
	 * 如果没有共享底层的 environment ，应用将继续运行，但是会抛出警告WARNING: More than 1 Couchbase
	 * Environments found (N), this can have severe impact on performance and
	 * stability. Reuse environments!
	 */
	// In general, this is an indication（指示） of misconfiguration（错误的配置）, the
	// only exception
	// being unit and integration（整合） tests where multiple paths are executed at
	// once and cannot share the ClusterEnvironment for whatever reason.
	/**
	 * 通常，这代表出现了错误的配置
	 * 这些异常仅仅可以出现在多路径的单元测试、或者整合测试中并且只运行一次。原因不能共享ClusterEnvironment。
	 */

}
