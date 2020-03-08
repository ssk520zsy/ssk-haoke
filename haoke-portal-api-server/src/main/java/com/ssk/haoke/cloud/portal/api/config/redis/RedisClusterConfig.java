package com.ssk.haoke.cloud.portal.api.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisClusterConfig {
    @Autowired
    private ClusterConfigurationProperties clusterProperties;

//    @Bean
//    public RedisConnectionFactory connectionFactory() {
//        RedisClusterConfiguration configuration = new RedisClusterConfiguration(clusterProperties.getNodes());
//        configuration.setMaxRedirects(clusterProperties.getMaxRedirects());
//        return new JedisConnectionFactory(configuration);
//    }
    @Bean
    public RedisConnectionFactory SingleConnectionFactory(){
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(clusterProperties.getHost());
        configuration.setPort(clusterProperties.getPort());
        return new JedisConnectionFactory(configuration);
    }
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory SingleConnectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(SingleConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}