package com.zjh;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6379));

        JedisCluster jedis = new JedisCluster(jedisClusterNodes);
        jedis.set("foo", "bar");
        String value = jedis.get("foo");

        System.out.println(value);
        Jedis jedisSimple = new Jedis("localhost",6379);
        System.out.println(jedisSimple.get("foo"));


        new JedisSentinelPool();

    }
}
