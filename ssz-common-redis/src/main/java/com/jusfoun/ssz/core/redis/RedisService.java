package com.jusfoun.ssz.core.redis;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.jusfoun.ssz.core.utils.ObjectUtils;
import com.jusfoun.ssz.core.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Desc: Redis 服务封装
 * Author: Cheng
 * Date: 2017/9/7 0014
 */
@Service
public class RedisService {
    private Logger logger = LoggerFactory.getLogger(RedisService.class);


    @Autowired
    private JedisCluster jedisCluster;

    public String get(String key) {
        String value = null;
        try {
            if (jedisCluster.exists(key)) {
                value = jedisCluster.get(key);
                value = value != null && !"".equals(value) && !"nil".equalsIgnoreCase(value) ? value : null;
                logger.debug("get {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("get {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return value;
    }

    public Object getObject(String key) {
        Object value = null;
        try {
            if (jedisCluster.exists(getBytesKey(key))) {
                value = toObject(jedisCluster.get(getBytesKey(key)));
                logger.debug("getObject {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObject {} = {}", key, value, e);
        } finally {
            //returnResource(jedis);
//			try {
//				jedisCluster.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        }
        return value;
    }

    public String set(String key, String value, int cacheSeconds) {
        String result = null;

        try {

            result = jedisCluster.set(key, value);
            if (cacheSeconds != 0) {
                jedisCluster.expire(key, cacheSeconds);
            }
            logger.debug("set {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("set {} = {}", key, value, e);
        } finally {
            //returnResource(jedis);
        }
        return result;
    }

    public String setObject(String key, Object value, int cacheSeconds) {
        String result = null;

        try {
            result = jedisCluster.set(getBytesKey(key), toBytes(value));
            if (cacheSeconds != 0) {
                jedisCluster.expire(key, cacheSeconds);
            }
            logger.debug("setObject {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObject {} = {}", key, value, e);
        } finally {
            //returnResource(jedis);
        }
        return result;
    }

    public List<String> getList(String key) {
        List<String> value = null;
        try {
            if (jedisCluster.exists(key)) {
                value = jedisCluster.lrange(key, 0, -1);
                logger.debug("getList {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getList {} = {}", key, value, e);
        } finally {
            //returnResource(jedis);
        }
        return value;
    }

    public List<Object> getObjectList(String key) {
        List<Object> value = null;
        try {
            if (jedisCluster.exists(getBytesKey(key))) {
                List<byte[]> list = jedisCluster.lrange(getBytesKey(key), 0, -1);
                value = Lists.newArrayList();
                for (byte[] bs : list) {
                    value.add(toObject(bs));
                }
                logger.debug("getObjectList {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObjectList {} = {}", key, value, e);
        } finally {
            //returnResource(jedis);
        }
        return value;
    }

    public long setList(String key, List<String> value, int cacheSeconds) {
        long result = 0;
        try {
            if (jedisCluster.exists(key)) {
                jedisCluster.del(key);
            }
            result = jedisCluster.rpush(key, (String[]) value.toArray());
            if (cacheSeconds != 0) {
                jedisCluster.expire(key, cacheSeconds);
            }
            logger.debug("setList {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setList {} = {}", key, value, e);
        } finally {
            //returnResource(jedis);
        }
        return result;
    }

    public long setObjectList(String key, List<Object> value, int cacheSeconds) {
        long result = 0;
        try {
            if (jedisCluster.exists(getBytesKey(key))) {
                jedisCluster.del(key);
            }
            List<byte[]> list = Lists.newArrayList();
            for (Object o : value) {
                list.add(toBytes(o));
            }
            result = jedisCluster.rpush(getBytesKey(key), (byte[][]) list.toArray());
            if (cacheSeconds != 0) {
                jedisCluster.expire(key, cacheSeconds);
            }
            logger.debug("setObjectList {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObjectList {} = {}", key, value, e);
        } finally {
            //returnResource(jedis);
        }
        return result;
    }

    public long listAdd(String key, String... value) {
        long result = 0;
        try {
            result = jedisCluster.rpush(key, value);
            logger.debug("listAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("listAdd {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public long listObjectAdd(String key, Object... value) {
        long result = 0;
        try {
            List<byte[]> list = Lists.newArrayList();
            for (Object o : value) {
                list.add(toBytes(o));
            }
            result = jedisCluster.rpush(getBytesKey(key), (byte[][]) list.toArray());
            logger.debug("listObjectAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("listObjectAdd {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public Set<String> getSet(String key) {
        Set<String> value = null;
        try {
            if (jedisCluster.exists(key)) {
                value = jedisCluster.smembers(key);
                logger.debug("getSet {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getSet {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return value;
    }

    public Set<Object> getObjectSet(String key) {
        Set<Object> value = null;
        try {
            if (jedisCluster.exists(getBytesKey(key))) {
                value = Sets.newHashSet();
                Set<byte[]> set = jedisCluster.smembers(getBytesKey(key));
                for (byte[] bs : set) {
                    value.add(toObject(bs));
                }
                logger.debug("getObjectSet {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObjectSet {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return value;
    }

    public long setSet(String key, Set<String> value, int cacheSeconds) {
        long result = 0;
        try {
            if (jedisCluster.exists(key)) {
                jedisCluster.del(key);
            }
            result = jedisCluster.sadd(key, (String[]) value.toArray());
            if (cacheSeconds != 0) {
                jedisCluster.expire(key, cacheSeconds);
            }
            logger.debug("setSet {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setSet {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public long setObjectSet(String key, Set<Object> value, int cacheSeconds) {
        long result = 0;
        try {
            if (jedisCluster.exists(getBytesKey(key))) {
                jedisCluster.del(key);
            }
            Set<byte[]> set = Sets.newHashSet();
            for (Object o : value) {
                set.add(toBytes(o));
            }
            result = jedisCluster.sadd(getBytesKey(key), (byte[][]) set.toArray());
            if (cacheSeconds != 0) {
                jedisCluster.expire(key, cacheSeconds);
            }
            logger.debug("setObjectSet {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObjectSet {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public long setSetAdd(String key, String... value) {
        long result = 0;
        try {
            result = jedisCluster.sadd(key, value);
            logger.debug("setSetAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setSetAdd {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public long setSetObjectAdd(String key, Object... value) {
        long result = 0;
        try {
            Set<byte[]> set = Sets.newHashSet();
            for (Object o : value) {
                set.add(toBytes(o));
            }
            result = jedisCluster.rpush(getBytesKey(key), (byte[][]) set.toArray());
            logger.debug("setSetObjectAdd {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setSetObjectAdd {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public Map<String, String> getMap(String key) {
        Map<String, String> value = null;
        try {
            if (jedisCluster.exists(key)) {
                value = jedisCluster.hgetAll(key);
                logger.debug("getMap {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getMap {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return value;
    }

    public Map<String, Object> getObjectMap(String key) {
        Map<String, Object> value = null;
        try {
            if (jedisCluster.exists(getBytesKey(key))) {
                value = Maps.newHashMap();
                Map<byte[], byte[]> map = jedisCluster.hgetAll(getBytesKey(key));
                for (Map.Entry<byte[], byte[]> e : map.entrySet()) {
                    value.put(StringUtils.toString(e.getKey()), toObject(e.getValue()));
                }
                logger.debug("getObjectMap {} = {}", key, value);
            }
        } catch (Exception e) {
            logger.warn("getObjectMap {} = {}", key, value, e);
        } finally {
        }
        return value;
    }

    public String setMap(String key, Map<String, String> value, int cacheSeconds) {
        String result = null;
        try {
            if (jedisCluster.exists(key)) {
                jedisCluster.del(key);
            }
            result = jedisCluster.hmset(key, value);
            if (cacheSeconds != 0) {
                jedisCluster.expire(key, cacheSeconds);
            }
            logger.debug("setMap {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setMap {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public String setObjectMap(String key, Map<String, Object> value, int cacheSeconds) {
        String result = null;
        try {
            if (jedisCluster.exists(getBytesKey(key))) {
                jedisCluster.del(key);
            }
            Map<byte[], byte[]> map = Maps.newHashMap();
            for (Map.Entry<String, Object> e : value.entrySet()) {
                map.put(getBytesKey(e.getKey()), toBytes(e.getValue()));
            }
            result = jedisCluster.hmset(getBytesKey(key), (Map<byte[], byte[]>) map);
            if (cacheSeconds != 0) {
                jedisCluster.expire(key, cacheSeconds);
            }
            logger.debug("setObjectMap {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("setObjectMap {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public String mapPut(String key, Map<String, String> value) {
        String result = null;
        try {
            result = jedisCluster.hmset(key, value);
            logger.debug("mapPut {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("mapPut {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public String mapObjectPut(String key, Map<String, Object> value) {
        String result = null;
        try {
            Map<byte[], byte[]> map = Maps.newHashMap();
            for (Map.Entry<String, Object> e : value.entrySet()) {
                map.put(getBytesKey(e.getKey()), toBytes(e.getValue()));
            }
            result = jedisCluster.hmset(getBytesKey(key), (Map<byte[], byte[]>) map);
            logger.debug("mapObjectPut {} = {}", key, value);
        } catch (Exception e) {
            logger.warn("mapObjectPut {} = {}", key, value, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public long mapRemove(String key, String mapKey) {
        long result = 0;
        try {
            result = jedisCluster.hdel(key, mapKey);
            logger.debug("mapRemove {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapRemove {}  {}", key, mapKey, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public long mapObjectRemove(String key, String mapKey) {
        long result = 0;
        try {
            result = jedisCluster.hdel(getBytesKey(key), getBytesKey(mapKey));
            logger.debug("mapObjectRemove {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapObjectRemove {}  {}", key, mapKey, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public boolean mapExists(String key, String mapKey) {
        boolean result = false;
        try {
            result = jedisCluster.hexists(key, mapKey);
            logger.debug("mapExists {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapExists {}  {}", key, mapKey, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public boolean mapObjectExists(String key, String mapKey) {
        boolean result = false;
        try {
            result = jedisCluster.hexists(getBytesKey(key), getBytesKey(mapKey));
            logger.debug("mapObjectExists {}  {}", key, mapKey);
        } catch (Exception e) {
            logger.warn("mapObjectExists {}  {}", key, mapKey, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public long del(String key) {
        long result = 0;
        try {
            if (jedisCluster.exists(key)) {
                result = jedisCluster.del(key);
                logger.debug("del {}", key);
            } else {
                logger.debug("del {} not exists", key);
            }
        } catch (Exception e) {
            logger.warn("del {}", key, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public long delObject(String key) {
        long result = 0;
        try {
            if (jedisCluster.exists(getBytesKey(key))) {
                result = jedisCluster.del(getBytesKey(key));
                logger.debug("delObject {}", key);
            } else {
                logger.debug("delObject {} not exists", key);
            }
        } catch (Exception e) {
            logger.warn("delObject {}", key, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public boolean exists(String key) {
        boolean result = false;
        try {
            result = jedisCluster.exists(key);
            logger.debug("exists {}", key);
        } catch (Exception e) {
            logger.warn("exists {}", key, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public boolean existsObject(String key) {
        boolean result = false;
        try {
            result = jedisCluster.exists(getBytesKey(key));
            logger.debug("existsObject {}", key);
        } catch (Exception e) {
            logger.warn("existsObject {}", key, e);
        } finally {
//			returnResource(jedis);
        }
        return result;
    }

    public String incr(String key) {
        Long result = 0L;
        try {
            result = jedisCluster.incr(key);
            logger.debug("existsObject {}", key);
        } catch (Exception e) {
            logger.warn("existsObject {}", key, e);
        } finally {
//			returnResource(jedis);
        }
        return String.valueOf(result);
    }

    public String hset(String key, String field, String value) {
        return jedisCluster.hset(key, field, value).toString();
    }


    /**
     * 获取byte[]类型Key
     *
     * @param object
     * @return
     */
    public static byte[] getBytesKey(Object object) {
        if (object instanceof String) {
            return StringUtils.getBytes((String) object);
        } else {
            return ObjectUtils.serialize(object);
        }
    }

    /**
     * Object转换byte[]类型
     *
     * @param object
     * @return
     */
    public static byte[] toBytes(Object object) {
        return ObjectUtils.serialize(object);
    }

    /**
     * byte[]型转换Object
     *
     * @param bytes
     * @return
     */
    public static Object toObject(byte[] bytes) {
        return ObjectUtils.unserialize(bytes);
    }
}
