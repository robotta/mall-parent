package com.malaysia.cache.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author
 */
public class RedisBaseTemplate {

	public static final Logger logger = LoggerFactory.getLogger(RedisBaseTemplate.class);

	protected RedisTemplate redisTemplate;

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void put(Object key, Object hashKey, Object value, final long activeTime) {
		redisTemplate.opsForHash().put(key, hashKey, value);
		if (activeTime > 0) {
			redisTemplate.expire(key, activeTime, TimeUnit.MINUTES);
		}
	}

	public Object get(Object key, Object hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}

}
