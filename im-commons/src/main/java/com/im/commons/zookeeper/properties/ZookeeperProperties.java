package com.im.commons.zookeeper.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * <p>Title: </p>
 * <p>Description: TODO(zookeeper配置文件)</p>
 * <p>Company: laixun</p>
 * @author Alix
 * @date 2019年8月15日 下午2:09:20
 */
@ConfigurationProperties(prefix="zookeeper")
@Validated
public class ZookeeperProperties {

    private String server;
    private String namespace;
    private String digest;
    private Integer sessionTimeoutMs = 60000;
    private Integer connectionTimeoutMs = 6000;
    private Integer maxRetries = 3;
    private Integer baseSleepTimeMs = 1000;
    
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public Integer getSessionTimeoutMs() {
		return sessionTimeoutMs;
	}
	public void setSessionTimeoutMs(Integer sessionTimeoutMs) {
		this.sessionTimeoutMs = sessionTimeoutMs;
	}
	public Integer getConnectionTimeoutMs() {
		return connectionTimeoutMs;
	}
	public void setConnectionTimeoutMs(Integer connectionTimeoutMs) {
		this.connectionTimeoutMs = connectionTimeoutMs;
	}
	public Integer getMaxRetries() {
		return maxRetries;
	}
	public void setMaxRetries(Integer maxRetries) {
		this.maxRetries = maxRetries;
	}
	public Integer getBaseSleepTimeMs() {
		return baseSleepTimeMs;
	}
	public void setBaseSleepTimeMs(Integer baseSleepTimeMs) {
		this.baseSleepTimeMs = baseSleepTimeMs;
	}
    
}
