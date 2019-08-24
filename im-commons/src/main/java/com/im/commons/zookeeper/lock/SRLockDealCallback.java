package com.im.commons.zookeeper.lock;

/**
 * <p>Title: </p>
 * <p>Description: TODO(获取可重入共享锁后的处理方法)</p>
 * <p>Company: laixun</p>
 * @author Alix
 * @date 2019年8月15日 下午2:15:55
 * @param <T>
 */
public interface SRLockDealCallback<T> {
	
	/**
	 * 获取可重入共享锁后的处理方法
	 * @return
	 */
	public T deal();

}
