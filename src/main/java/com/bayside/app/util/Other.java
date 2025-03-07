package com.bayside.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class Other {
	private static Logger logger = Logger.getLogger(Other.class);  
	/**
	 * 
	 * <p>
	 * 方法名称：getSystemRoot
	 * </p>
	 * <p>
	 * 方法描述：获取系统命令路径 ：SystemRoot=C:\WINDOWS
	 * </p>
	 * 
	 * @return
	 * @author liuyy
	 * @since 2016年10月27日
	 *        <p>
	 *        history 2016年10月27日 Administrator 创建
	 *        <p>
	 */
	public static String getSystemRoot() {
		String cmd = null;
		String os = null;
		String result = null;
		String envName = "windir";
		os = System.getProperty("os.name").toLowerCase();
		if (os.startsWith("windows")) {
			cmd = "cmd /c SET";
		} else {
			cmd = "env";
		}
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader commandResult = new BufferedReader(isr);
			String line = null;
			while ((line = commandResult.readLine()) != null) {
				line = line.toLowerCase();// 重要(同一操作系统不同电脑有些返回的是小写,有些是大写.因此需要统一转换成小写)
				if (line.indexOf(envName) > -1) {
					result = line.substring(line.indexOf(envName) + envName.length() + 1);
					return result;
				}
			}
		} catch (Exception e) {
			System.out.println("获取系统命令路径 error: " + cmd + ":" + e);
			logger.info(e.getMessage());
			logger.error(e.getMessage(),e);
		}
		return null;
	}



	public static String getWindowXPMACAddress(String execStr) {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			// windows下的命令，显示信息中包含有mac地址信息
			process = Runtime.getRuntime().exec(execStr);
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.indexOf("本地连接") != -1) // 排除有虚拟网卡的情况
					continue;

				// 寻找标示字符串[physical address]
				index = line.toLowerCase().indexOf("physical address");
				if (index != -1) {
					index = line.indexOf(":");
					if (index != -1) {
						// 取出mac地址并去除2边空格
						mac = line.substring(index + 1).trim();
					}
					break;
				}
			}
		} catch (IOException e) {
			logger.info(e.getMessage());
			logger.error(e.getMessage(),e);
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				logger.info(e1.getMessage());
				logger.error(e1.getMessage(),e1);
			}
			bufferedReader = null;
			process = null;
		}
		return mac;
	}

	public static String getWindow7MACAddress() {
		// 获取本地IP对象
		InetAddress ia = null;
		try {
			ia = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			logger.info(e.getMessage());
			logger.error(e.getMessage(),e);
		}
		// 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
		byte[] mac = null;
		try {
			if(ia!=null){
				mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
			}
			
		} catch (SocketException e) {
			logger.info(e.getMessage());
			logger.error(e.getMessage(),e);
		}
		// 下面代码是把mac地址拼装成String
		StringBuffer sb = new StringBuffer();
		if(null!=mac){
			for (int i = 0; i < mac.length; i++) {
				if (i != 0) {
					sb.append("-");
				}
				// mac[i] & 0xFF 是为了把byte转化为正整数
				String s = Integer.toHexString(mac[i] & 0xFF);
				sb.append(s.length() == 1 ? 0 + s : s);
			}
		}
		// 把字符串所有小写字母改为大写成为正规的mac地址并返回
		return sb.toString().toUpperCase();
	}

	public static String getLinuxMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			// linux下的命令，一般取eth0作为本地主网卡 显示信息中包含有mac地址信息
			process = Runtime.getRuntime().exec("ifconfig eth0");
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				index = line.toLowerCase().indexOf("硬件地址");
				if (index != -1) {
					// 取出mac地址并去除2边空格
					mac = line.substring(index + 4).trim();
					break;
				}
			}
		} catch (IOException e) {
			logger.info(e.getMessage());
			logger.error(e.getMessage(),e);
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				logger.info(e1.getMessage());
				logger.error(e1.getMessage(),e1);
			}
			bufferedReader = null;
			process = null;
		}
		return mac;
	}

	public static String getUnixMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			// Unix下的命令，一般取eth0作为本地主网卡 显示信息中包含有mac地址信息
			process = Runtime.getRuntime().exec("ifconfig eth0");
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				// 寻找标示字符串[hwaddr]
				index = line.toLowerCase().indexOf("hwaddr");
				if (index != -1) {
					// 取出mac地址并去除2边空格
					mac = line.substring(index + "hwaddr".length() + 1).trim();
					break;
				}
			}
		} catch (IOException e) {
			logger.info(e.getMessage());
			logger.error(e.getMessage(),e);
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				logger.info(e1.getMessage());
				logger.error(e1.getMessage(),e1);
			}
			bufferedReader = null;
			process = null;
		}

		return mac;
	}

	
}
