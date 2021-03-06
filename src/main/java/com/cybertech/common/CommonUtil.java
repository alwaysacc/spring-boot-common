package com.cybertech.common;

import java.io.*;
import java.text.DecimalFormat;

/**
 * ${DESCRIPTION}
 *
 * @author wuxw
 * @date 2018/12/12. 2:49 PM
 */
public class CommonUtil {

	//序列化
	public static byte [] serialize(Object obj){

		ObjectOutputStream obi=null;
		ByteArrayOutputStream bai=null;
		try {
			bai=new ByteArrayOutputStream();
			obi=new ObjectOutputStream(bai);
			obi.writeObject(obj);
			byte[] byt=bai.toByteArray();
			return byt;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//反序列化
	public static Object unserizlize(byte[] byt){
		ObjectInputStream oii=null;
		ByteArrayInputStream bis=null;
		bis=new ByteArrayInputStream(byt);
		try {
			oii=new ObjectInputStream(bis);
			Object obj=oii.readObject();
			return obj;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	//整型相除保留两位小数
	public static String int2Decimal(int a,int b){

		DecimalFormat df = new DecimalFormat("0.00");
		String rate = df.format((float)a/b);
		return rate;
	}
}
