package com.im.commons.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * <p>Title: </p>
 * <p>Description: TODO(日期时间工具类)</p>
 * <p>Company: laixun</p>
 * @author Alix
 * @date 2019年8月12日 上午9:27:19
 */
public class DateTimeUtils {

	/**
	 * @Title: getTime
	 * @Description: TODO(获取系统时间)
	 * @param: @param format
	 * @param: @return   
	 * @return: String   
	 * @throws
	 */
	public static String getTime(String format) {
		LocalDateTime dt = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return dt.format(formatter);
	}
	
}
