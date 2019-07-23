package com.lhy.fool.util.other;

import java.util.Random;
import java.util.UUID;

/**
 * 生成随机数工具类
 * @author lhy
 */
public class RandomUtil {

	private static final int SIXTEEN=16;
	/**
	 * 生成随机数字和字母
	 * 
	 * @param length
	 * @return
	 */
	public static String getStringRandom(int length) {
		String val = "";
		Random random = new Random();
		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				//int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				int temp = 65;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	/**
	 * @return 创建唯一NO
	 */
	public static String createNo() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}


	public static String getUUIDRandom() {
		Random rd = new Random();
		String res = Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
				+ Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
				+ Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
				+ Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
				+ Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
				+ Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
				+ Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
				+ Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
				+ Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase()
				+ Integer.toHexString(rd.nextInt(SIXTEEN)).toUpperCase();
		return res;
	}
	/**
	 * 测试抽奖算法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getStringRandom(8));
	}
}
