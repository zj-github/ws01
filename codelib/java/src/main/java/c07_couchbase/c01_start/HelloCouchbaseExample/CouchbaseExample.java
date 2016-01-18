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
		// to a cluster where the cluster is reachable（可达的） on localhost. This
		// type
		// of connection is a reasonable（合理的） default to get started during
		// development, but in production you should pass in more seed nodes
		// like this:通常在生产环境中，你需要添加更多的节点，像下面那样

		// Cluster cluster = CouchbaseCluster.create("192.168.56.101",
		// "192.168.56.102");

		// You do not need to pass in all nodes of the cluster你不需要输入集群中的所有节点,
		// just a few seed
		// nodes so that the client can establish the initial
		// contact仅仅添加一些，让客户端可以初始化连同的链接. The
		// actual process of connecting to a bucket (that is, opening sockets
		// and everything related 指的是打开socket以及相关的) happens when you call the
		// openBucket
		// method:实际的链接到桶的操作发生在你调用openBucket 方法

		final Bucket bucket = cluster.openBucket();
		// This will connect to the default bucket and return a Bucket
		// reference.这将链接到默认的额桶，并返回桶的引用。

		// If you want to connect to a different bucket (also with a password),
		// you can do it like this:如果你想连接到不同的桶，并且带了密码，你可以这样
		// Bucket bucket = cluster.openBucket("bucket", "password");

		// When your application shuts down当你的应用关闭, you need to make sure to
		// disconnect你需要确保释放所有的socket 线程资源
		// properly from the cluster to free all resources (sockets, threads,
		// and so on). The following code shuts down the client:
		// cluster.disconnect();
		// This disconnects all buckets and makes the associated resources
		// available.这样就释放了所有的buckets，并使相关的资源又可以被使用了。

		// You now have a reference to the Bucket, so you can begin working with
		// it. The SDK comes with built-in handling for JSON documents, which
		// you can use right away sdk自带了处理json文档的api，可以直接使用. First, create a
		// JsonObject, which contains
		// information for a user.创建一个携带用户信息的JsonObject
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
		// bucket.你可以使用使用upsert方法来存储文档
		// Because a document on the server has more properties than just the
		// content, you need to give it at least a unique document ID
		// 你需要给一个唯一的文档id(for
		// example, walter). The container for all this information is
		// called（被称为） a
		// Document and because you are dealing with JSON you need to create a
		// JsonDocument:容纳信息的容器被称为文档，并且因为你使用了Json格式的数据，所以你需要创建一个JsonDocument

		JsonDocument doc = JsonDocument.create("walter", user);
		JsonDocument response = bucket.upsert(doc);
		// The Document is automatically converted into JSON and stored on the
		// cluster文档将自动转换成Json并且存储到服务器上. If the document (identified by its
		// unique ID) already
		// exists, it is replaced.如果文档已经存在了，旧的将会被替代

		/*
		 * If you replace upsert with insert and try to insert the same document
		 * twice (with the same ID), you see the following：如果把upsert替换成insert
		 * ，插入两次会出现下面的异常 Exception in thread "main"
		 * com.couchbase.client.java.error.DocumentAlreadyExistsException at
		 * com.couchbase.client.java.CouchbaseAsyncBucket$12.call(
		 * CouchbaseAsyncBucket.java:425) at
		 * com.couchbase.client.java.CouchbaseAsyncBucket$12.call(
		 * CouchbaseAsyncBucket.java:409) ...
		 */
		// This provides an important clue（线索）:
		// insert, unlike upsert fails if the document already exists on the
		// server (very much like the SQL INSERT statement).
		// 插入的时候，不想upsert失败如果已经存在，会插入失败

		// If you replace upsert with insert and try to insert the same document
		// twice (with the same ID), you see the following:

		// 根据id检索文档
		// Not surprisingly, you can also retrieve（检索） a Document from the
		// database. You do this by providing its ID:
		JsonDocument walter = bucket.get("walter");
		System.out.println("Found: " + walter);

		// If you want to print only the age, you can reach into the content
		// (much like you would access a `Map`):获取文档中的一个field
		System.out.println("Age: " + walter.content().getInt("age"));
		// You can combine both commands to implement something that is needed
		// very often: loading a document, modifying its content and then
		// storing the modified document.你可以这样做：加载一个文档，修改他的内容，然后再存入库中

		// First, here is one of the possible way to do it synchronously（同步）:
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
		// You can think of replace as the opposite（相反） of insert—if the
		// document
		// does not already exist, the call will fail with a
		// DocumentDoesNotExistException.

		// The code shown above is completely synchronous上面的代码使完全的同步, which
		// means that your
		// main thread will wait all the time until a response comes back from
		// the server意味着你的主线程将等待直到获取响应. It waits for network IO to happen while
		// instead it could
		// perform valuable work. Instead of waiting and "pulling" the data out
		// of the SDK, you can just keep going forward in your application flow
		// and let the SDK notify you once it's done with work.

		// Observables（观察的到的） provide a large range of methods and functionality
		// to
		// create, combine and transform asynchronous workflows and make them
		// look synchronous (while they aren't). Other approaches（方法） quickly
		// get
		// you into "callback hell" and are complicated（复杂） dealing with
		// futures,
		// especially（尤其是） if you want to chain more than one asynchronous
		// operation
		// together, let alone proper error handling.更不用说正确的错误处理。

		// Here is the very same example, but completely non-blocking (note that
		// you want to keep your main thread alive with a Thread.sleep() for now
		// or use CountDownLatch):这是一个非简单的，实现了完全非阻塞的例子。

		bucket.async().get("walter").flatMap(new Func1<JsonDocument, Observable<JsonDocument>>() {
			@Override
			public Observable<JsonDocument> call(final JsonDocument loaded) {
				loaded.content().put("age", 52);
				return bucket.async().replace(loaded);
			}
		})/** 修改数据 */
				.subscribe(new Action1<JsonDocument>() {
					@Override
					public void call(final JsonDocument updated) {
						System.out.println("Updated: " + updated.id());
					}
				});/** 将修改后的数据存入数据库 */

		// in Couchbase 4.0, a new query language has been introduced: N1QL.
		// Since it is a superset（超集） of SQL, we can write a Hello World example
		// using N1QL. Make sure to have the query service activated in your
		// cluster and a primary index created on your bucket. See Querying with
		// N1QL):
		
		/**
		 * 4.0版本以后，有了n1ql,是一种新的查询语言，它是传统sql的超集
		 * 需要确保你的查询服务激活，并且在你要查询的桶上游主索引
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
		// “Hello, users in their fifties:
		// Walter!"

//		 Statement statement =
//		 Select.select(x("firstname")).from(i("default"))
//		 .where(x("age").between(49).and(59));
//		 N1qlQuery query = N1qlQuery.simple(statement);

	}
}
