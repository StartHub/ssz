package com.jusfoun.ssz.core.redis.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import javax.inject.Singleton;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaxuan on 16/11/8.
 * 获取JedisCluster的配置
 */
@Configuration
@ConditionalOnClass({JedisCluster.class})
public class JedisClusterConfig {
    @Value("${spring.redis.clusterNodes}")
    private String clusterNodes;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.commandTimeout}")
    private int commandTimeout;
    @Value("${spring.redis.soTimeout}")
    private int soTimeout;
    @Value("${spring.redis.maxRedirections}")
    private int maxRedirections;
    @Value("${spring.redis.pool.maxWaitMillis}")
    private Long maxWaitMillis;
    @Value("${spring.redis.pool.minIdle}")
    private int minIdle;
    @Value("${spring.redis.pool.maxTotal}")
    private int maxTotal;
    @Value("${spring.redis.pool.maxIdle}")
    private int maxIdle;

    @Bean
    @Singleton
    public JedisCluster getJedisCluster() {
        String[] serverArray = clusterNodes.split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String ipPort: serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(),Integer.valueOf(ipPortPair[1].trim())));
        }

        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMaxTotal(maxTotal);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxWaitMillis(maxWaitMillis);

        return new JedisCluster(nodes, commandTimeout, soTimeout, maxRedirections, password , genericObjectPoolConfig);
    }
}