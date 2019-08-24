package com.im.commons.utils;

import java.io.IOException;
import java.util.Scanner;

/**
 * <p>Title: </p>
 * <p>Description: TODO(系统工具类)</p>
 * <p>Company: laixun</p>
 * @author Alix
 * @date 2019年8月8日 下午7:51:56
 */
public class SystemUtils {

	/**
	 * @Title: getProcessorId
	 * @Description: TODO(获取本机机器码)
	 * @param: @return
	 * @param: @throws IOException   
	 * @return: String   
	 * @throws
	 */
	public static String getProcessorId() throws IOException {
        Process process = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });  
        process.getOutputStream().close();  
        Scanner sc = new Scanner(process.getInputStream());  
        String property = sc.next();  
        String serial = sc.next();  
        System.out.println(property + ": " + serial); 
        sc.close();
        return serial;
	}
	
}
