package org.test;

import java.util.Arrays;

public class LastString {

	public static String lastDictionaryString(String str) {

		String res = "";

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isAlphabetic(c)) {
				res += c;
			}
		}
		String lowerCase = res.toLowerCase();

		char[] charArray = lowerCase.toCharArray();
		Arrays.sort(charArray);
		int left = 0;
		int right = charArray.length - 1;

		while (left < right) {
			char temp = charArray[left];
			charArray[left] = charArray[right];
			charArray[right] = temp;

			left++;
			right--;
		}

		String string = new String(charArray);

		return string;

	}

	public static void main(String[] args) {

		String str1 = "ab5bcc*ccdd";
		String str2 = "cd2ez-f";
		String str3 = "Rg^w4io";

		System.out.println(lastDictionaryString(str1));
		System.out.println(lastDictionaryString(str2));
		System.out.println(lastDictionaryString(str3));
	}

}
