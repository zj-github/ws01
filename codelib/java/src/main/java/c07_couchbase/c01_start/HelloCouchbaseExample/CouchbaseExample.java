package c07_couchbase.c01_start.HelloCouchbaseExample;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.couchbase.client.java.query.Select;
import com.couchbase.client.java.query.Statement;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class CouchbaseExample {

	public static void main(String[] args) {
		Cluster cluster = CouchbaseCluster.create();
		// With no other arguments provided, this connection will logically bind
		// to a cluster where the cluster is reachable���ɴ�ģ� on localhost. This
		// type
		// of connection is a reasonable������ģ� default to get started during
		// development, but in production you should pass in more seed nodes
		// like this:ͨ�������������У�����Ҫ��Ӹ���Ľڵ㣬����������

		// Cluster cluster = CouchbaseCluster.create("192.168.56.101",
		// "192.168.56.102");

		// You do not need to pass in all nodes of the cluster�㲻��Ҫ���뼯Ⱥ�е����нڵ�,
		// just a few seed
		// nodes so that the client can establish the initial
		// contact�������һЩ���ÿͻ��˿��Գ�ʼ����ͬ������. The
		// actual process of connecting to a bucket (that is, opening sockets
		// and everything related ָ���Ǵ�socket�Լ���ص�) happens when you call the
		// openBucket
		// method:ʵ�ʵ����ӵ�Ͱ�Ĳ��������������openBucket ����

		final Bucket bucket = cluster.openBucket();
		// This will connect to the default bucket and return a Bucket
		// reference.�⽫���ӵ�Ĭ�ϵĶ�Ͱ��������Ͱ�����á�

		// If you want to connect to a different bucket (also with a password),
		// you can do it like this:����������ӵ���ͬ��Ͱ�����Ҵ������룬���������
		// Bucket bucket = cluster.openBucket("bucket", "password");

		// When your application shuts down�����Ӧ�ùر�, you need to make sure to
		// disconnect����Ҫȷ���ͷ����е�socket �߳���Դ
		// properly from the cluster to free all resources (sockets, threads,
		// and so on). The following code shuts down the client:
		// cluster.disconnect();
		// This disconnects all buckets and makes the associated resources
		// available.�������ͷ������е�buckets����ʹ��ص���Դ�ֿ��Ա�ʹ���ˡ�

		// You now have a reference to the Bucket, so you can begin working with
		// it. The SDK comes with built-in handling for JSON documents, which
		// you can use right away sdk�Դ��˴���json�ĵ���api������ֱ��ʹ��. First, create a
		// JsonObject, which contains
		// information for a user.����һ��Я���û���Ϣ��JsonObject
		JsonObject user = JsonObject.empty().put("firstname", "Walter").put("lastname", "White")
				.put("job", "chemistry teacher").put("age", 50);

		/*
		 * A JsonObject works very much like a Map, but it is designed to only
		 * let you insert values that can be stored as valid JSON (including
		 * nested objects and arrays). The resulting document looks like this:
		 * 
		 * { "firstname":"Walter", "job":"chemistry teacher", "age":50,
		 * "lastname":"White" }
		 */

		// To store the document, you can use the upsert method on the
		// bucket.�����ʹ��ʹ��upsert�������洢�ĵ�
		// Because a document on the server has more properties than just the
		// content, you need to give it at least a unique document ID
		// ����Ҫ��һ��Ψһ���ĵ�id(for
		// example, walter). The container for all this information is
		// called������Ϊ�� a
		// Document and because you are dealing with JSON you need to create a
		// JsonDocument:������Ϣ����������Ϊ�ĵ���������Ϊ��ʹ����Json��ʽ�����ݣ���������Ҫ����һ��JsonDocument

		JsonDocument doc = JsonDocument.create("walter", user);
		JsonDocument response = bucket.upsert(doc);
		// The Document is automatically converted into JSON and stored on the
		// cluster�ĵ����Զ�ת����Json���Ҵ洢����������. If the document (identified by its
		// unique ID) already
		// exists, it is replaced.����ĵ��Ѿ������ˣ��ɵĽ��ᱻ���

		/*
		 * If you replace upsert with insert and try to insert the same document
		 * twice (with the same ID), you see the following�������upsert�滻��insert
		 * ���������λ����������쳣 Exception in thread "main"
		 * com.couchbase.client.java.error.DocumentAlreadyExistsException at
		 * com.couchbase.client.java.CouchbaseAsyncBucket$12.call(
		 * CouchbaseAsyncBucket.java:425) at
		 * com.couchbase.client.java.CouchbaseAsyncBucket$12.call(
		 * CouchbaseAsyncBucket.java:409) ...
		 */
		// This provides an important clue��������:
		// insert, unlike upsert fails if the document already exists on the
		// server (very much like the SQL INSERT statement).
		// �����ʱ�򣬲���upsertʧ������Ѿ����ڣ������ʧ��

		// If you replace upsert with insert and try to insert the same document
		// twice (with the same ID), you see the following:

		// ����id�����ĵ�
		// Not surprisingly, you can also retrieve�������� a Document from the
		// database. You do this by providing its ID:
		JsonDocument walter = bucket.get("walter");
		System.out.println("Found: " + walter);

		// If you want to print only the age, you can reach into the content
		// (much like you would access a `Map`):��ȡ�ĵ��е�һ��field
		System.out.println("Age: " + walter.content().getInt("age"));
		// You can combine both commands to implement something that is needed
		// very often: loading a document, modifying its content and then
		// storing the modified document.�����������������һ���ĵ����޸��������ݣ�Ȼ���ٴ������

		// First, here is one of the possible way to do it synchronously��ͬ����:
		JsonDocument loaded = bucket.get("walter");
		if (loaded == null) {
			System.err.println("Document not found!");
		} else {
			loaded.content().put("age", 52);
			JsonDocument updated = bucket.replace(loaded);
			System.out.println("Updated: " + updated.id());
		}

		// The code uses the get method to load the Document and then waits
		// until it arrives from the server (returns null as the default value
		// if it does not exist). If it is not null, the content is modified and
		// the document is stored again through the synchronous replace method.
		// You can think of replace as the opposite���෴�� of insert��if the
		// document
		// does not already exist, the call will fail with a
		// DocumentDoesNotExistException.

		// The code shown above is completely synchronous����Ĵ���ʹ��ȫ��ͬ��, which
		// means that your
		// main thread will wait all the time until a response comes back from
		// the server��ζ��������߳̽��ȴ�ֱ����ȡ��Ӧ. It waits for network IO to happen while
		// instead it could
		// perform valuable work. Instead of waiting and "pulling" the data out
		// of the SDK, you can just keep going forward in your application flow
		// and let the SDK notify you once it's done with work.

		// Observables���۲�ĵ��ģ� provide a large range of methods and functionality
		// to
		// create, combine and transform asynchronous workflows and make them
		// look synchronous (while they aren't). Other approaches�������� quickly
		// get
		// you into "callback hell" and are complicated�����ӣ� dealing with
		// futures,
		// especially�������ǣ� if you want to chain more than one asynchronous
		// operation
		// together, let alone proper error handling.������˵��ȷ�Ĵ�����

		// Here is the very same example, but completely non-blocking (note that
		// you want to keep your main thread alive with a Thread.sleep() for now
		// or use CountDownLatch):����һ���Ǽ򵥵ģ�ʵ������ȫ�����������ӡ�

		bucket.async().get("walter").flatMap(new Func1<JsonDocument, Observable<JsonDocument>>() {
			@Override
			public Observable<JsonDocument> call(final JsonDocument loaded) {
				loaded.content().put("age", 52);
				return bucket.async().replace(loaded);
			}
		})/** �޸����� */
				.subscribe(new Action1<JsonDocument>() {
					@Override
					public void call(final JsonDocument updated) {
						System.out.println("Updated: " + updated.id());
					}
				});/** ���޸ĺ�����ݴ������ݿ� */

		// in Couchbase 4.0, a new query language has been introduced: N1QL.
		// Since it is a superset�������� of SQL, we can write a Hello World example
		// using N1QL. Make sure to have the query service activated in your
		// cluster and a primary index created on your bucket. See Querying with
		// N1QL):
		
		/**
		 * 4.0�汾�Ժ�����n1ql,��һ���µĲ�ѯ���ԣ����Ǵ�ͳsql�ĳ���
		 * ��Ҫȷ����Ĳ�ѯ���񼤻��������Ҫ��ѯ��Ͱ����������
		 */
		String statement = "SELECT firstname FROM `default` WHERE age BETWEEN 49 AND 59";
		N1qlQuery query = N1qlQuery.simple(statement);
		N1qlQueryResult result = bucket.query(query);
		System.out.println("Hello, users in their fifties: ");
		for (N1qlQueryRow row : result) {
			String firstName = row.value().getString("firstname");
			System.out.println(firstName + "!");
		}
		// prints:
		// ��Hello, users in their fifties:
		// Walter!"

//		 Statement statement =
//		 Select.select(x("firstname")).from(i("default"))
//		 .where(x("age").between(49).and(59));
//		 N1qlQuery query = N1qlQuery.simple(statement);

	}
}
