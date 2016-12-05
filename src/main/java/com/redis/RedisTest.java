package com.redis;

import redis.clients.jedis.Jedis;

public class RedisTest {
	private static Jedis jedis;
	
	public static void setup(){
		jedis = new Jedis("127.0.0.1", 6379);
//		jedis.auth("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setup();
//		jedis.set("name", "zhangsan");
//		jedis.set("age", "14");
//		Person person = new Person("zhangsan","23","male");
//		jedis.set("person".getBytes(), SerializeUtil.serialize(person));
//		Person p = (Person) SerializeUtil.unserialize(jedis.get("person").getBytes());
		System.out.println(jedis.get("person"));
	}

}
