package com.ezeon.capp.util;


/**
 * This class contains utility methods related to String Operations. 
 * @author Sreekanth
 *
 */
public class StringUtil {

	public static String toCommaSeparatedString(Object[] items) {
		StringBuilder stringBuilder = new StringBuilder();
		for(Object item:items) {
			stringBuilder.append(item).append(",");
		}
		if(stringBuilder.length()>0) {
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		return stringBuilder.toString();
	}
}
