package com.im.commons.redis.customized;

import java.nio.charset.Charset;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * <p>Title: </p>
 * <p>Description: TODO(
 * alibaba.fastjson内部已经提供了对Redis存储对象序列化的工具类GenericFastJsonRedisSerializer，但是该工具在反序列化时返回为Object。
 * 本类是仿照GenericFastJsonRedisSerializer来自定义一个扩展的工具类，反序列化后自动转化为指定的java对象。
 * )</p>
 * <p>Company: laixun</p>
 * @author Alix
 * @date 2019年8月10日 上午10:36:33
 * @param <T>
 */
public class CustomizedFastJsonRedisSerializer<T> implements RedisSerializer<T> {

	private final static ParserConfig defaultRedisConfig = new ParserConfig();
	static {
		defaultRedisConfig.setAutoTypeSupport(true);
	}

	/**
	 * DEFAULT_CHARSET <br>
	 */
	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	/**
	 * clazz 反序列化类<br>
	 */
	private Class<T> clazz;

	/**
	 * <Description> 构造器<br>
	 * 
	 * @param clazz
	 *            反序列化目标类
	 */
	public CustomizedFastJsonRedisSerializer(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	/**
	 * Description: 序列化<br>
	 * 
	 * @author xubin<br>
	 * @taskId <br>
	 * @param t
	 * @return
	 * @throws SerializationException
	 *             <br>
	 */
	@Override
	public byte[] serialize(T t) throws SerializationException {
		if (t == null) {
			return new byte[0];
		}
		return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
	}

	/**
	 * Description: 反序列化<br>
	 * 
	 * @author xubin<br>
	 * @taskId <br>
	 * @param bytes
	 * @return
	 * @throws SerializationException
	 *             <br>
	 */
	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null || bytes.length <= 0) {
			return null;
		}
		String str = new String(bytes, DEFAULT_CHARSET);
		return (T) JSON.parseObject(str, clazz, defaultRedisConfig);
	}

}
