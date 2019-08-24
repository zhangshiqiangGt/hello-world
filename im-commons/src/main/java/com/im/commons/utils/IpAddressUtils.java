package com.im.commons.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description: TODO(IP工具类)
 * </p>
 * <p>
 * Company: laixun
 * </p>
 * 
 * @author Alix
 * @date 2019年8月12日 上午9:55:46
 */
public class IpAddressUtils {
	/**
	 * @Title: getIntranetIp @Description: TODO(获得内网IP) @param: @return @return:
	 * String @throws
	 */
	public static String getIntranetIp() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Title: getInternetIp @Description: TODO(获得外网IP) @param: @return @return:
	 * String @throws
	 */
	public static String getInternetIp() {
		try {

			String INTRANET_IP = getIntranetIp();

			Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			Enumeration<InetAddress> addrs;
			while (networks.hasMoreElements()) {
				addrs = networks.nextElement().getInetAddresses();
				while (addrs.hasMoreElements()) {
					ip = addrs.nextElement();
					if (ip != null && ip instanceof Inet4Address 
							&& ip.isSiteLocalAddress()
							&& !ip.getHostAddress().equals(INTRANET_IP)) {
						System.out.println("ip列表：" + ip);
//						return ip.getHostAddress();
					}
				}
			}

			//如果没有外网IP，就返回内网IP
			return INTRANET_IP;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		System.out.println(getIntranetIp());
		System.out.println(getInternetIp());
	}
}