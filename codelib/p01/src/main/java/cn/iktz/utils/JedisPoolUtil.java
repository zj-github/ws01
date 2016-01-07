/* 
 * JedisPoolTest.java 
 */
package cn.iktz.utils;

import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {

	{
		JedisPoolConfig jedisPoolConfig = initPoolConfig();
		// ResourceBundle bundle = ResourceBundle.getBundle("redis_config");
		// String host = bundle.getString("redis.host");
		// int port = Integer.valueOf(bundle.getString("redis.port"));
		// int timeout = Integer.valueOf(bundle.getString("redis.timeout"));
		// String password = bundle.getString("redis.password");
		jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 20000);
	}

	private static JedisPool jedisPool;

	private static JedisPoolConfig initPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxActive(1000);
		jedisPoolConfig.setMaxIdle(300);
		jedisPoolConfig.setMaxWait(1000);
		jedisPoolConfig.setTestOnBorrow(true);
		jedisPoolConfig.setTestOnReturn(true);
		return jedisPoolConfig;
	}

	public static  void set(String k, String v) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.set(k, v);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			jedisPool.returnResource(jedis);
		}
	}

	public static String get(String k) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.get(k);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			jedisPool.returnResource(jedis);
		}
		return "";
	}
	public static void set(String k,Map<String,String> map) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.hmset(k, map);
		} catch (Exception e) {
			jedisPool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			jedisPool.returnResource(jedis);
		}
	}
}