
/* 
 * JedisTest.java 
 */
package cn.iktz.jedis.test;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * jedis ��ʹ��
 * 
 * @author http://blog.csdn.net/java2000_wl
 * @version <b>1.0</b>
 */
public class JedisSimpleTest {

	private Jedis jedis;

	/**
	 * ��ʼ������ <br>
	 * ------------------------------<br>
	 */
	@Before
	public void beforeClass() {
		jedis = new Jedis("127.0.0.1");
		jedis.auth("java2000_wl");
	}

	/**
	 * set ���� <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testSet() {
		jedis.set("blog", "java2000_wl");
	}

	/**
	 * ��ȡ <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testGet() {
		System.out.println(jedis.get("blog"));
	}

	/**
	 * �޸�key <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testRenameKey() {
		jedis.rename("blog", "blog_new");
	}

	/**
	 * ��keyɾ�� <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testDel() {
		jedis.del("blog_new");
	}

	/**
	 * ��ȡ���е�key <br>
	 * ------------------------------<br>
	 */
	@Test
	public void testKeys() {
		System.out.println(jedis.keys("*"));
	}
}