/* 
 * JedisPoolTest.java 
 */  
package cn.iktz.jedis.test;  
   
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;  
   
public class JedisPoolTest {  
   
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
       
    @BeforeClass  
    public static void before() {  
        JedisPoolConfig jedisPoolConfig = initPoolConfig();    
//        ResourceBundle bundle = ResourceBundle.getBundle("redis_config");  
//        String host = bundle.getString("redis.host");  
//        int port = Integer.valueOf(bundle.getString("redis.port"));  
//        int timeout = Integer.valueOf(bundle.getString("redis.timeout"));  
//        String password = bundle.getString("redis.password");  
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 20000);  
    }  
   
    @Test  
    public void testSet() {  
        Jedis jedis = null;   
        try {  
            jedis = jedisPool.getResource();  
            jedis.set("blog_pool", "java2000_wl");  
        } catch (Exception e) {  
            jedisPool.returnBrokenResource(jedis);  
            Assert.fail(e.getMessage());  
        } finally {  
            jedisPool.returnResource(jedis);  
        }  
    }         
       
    @Test  
    public void testGet() {  
        Jedis jedis = null;   
        try {  
            jedis = jedisPool.getResource();  
            System.out.println(jedis.get("blog_pool"));  
        } catch (Exception e) {  
            jedisPool.returnBrokenResource(jedis);  
            Assert.fail(e.getMessage());  
        } finally {  
            jedisPool.returnResource(jedis);  
        }  
    }  
}