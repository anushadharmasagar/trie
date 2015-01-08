/** COPYRIGHT (C) 2015 Anusha. All Rights Reserved. */
package com.pramati.tries.utils;

/**
 * class to remove special characters in the word.
 * 
 * @author anusha
 *
 */

public class CleanWord {

	/**
	 * removes all the special characters in the line
	 * 
	 * @param word
	 * @return the modified current line
	 */

	public static String cleanUp(String word) {
		String result = new String();
		for (char ch : word.toCharArray()) {
			if ((ch > 64 && ch < 91) || (ch > 96 && ch < 128)) {
				result += ch;
			}
		}
		return result;
	}

}
