package com.im.commons.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.im.commons.redis.customized.CustomizedFastJsonRedisSerializer;

/**
 * <p>Title: </p>
 * <p>Description: TODO(Redis自定义配置)</p>
 * <p>Company: laixun</p>
 * @author Alix
 * @date 2019年8月10日 上午9:46:19
 */
@Configuration
public class RedisConfig {

	@Bean(name="fastJsonRedisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
 
        CustomizedFastJsonRedisSerializer<Object> serializer = new CustomizedFastJsonRedisSerializer<Object>(Object.class);
//        GenericFastJsonRedisSerializer serializer = new GenericFastJsonRedisSerializer();
         
     // value值的序列化采用fastJsonRedisSerializer
        template.setValueSerializer(serializer);
        template.setHashValueSerializer(serializer);
        
        // key的序列化采用StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
 
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
    
}
