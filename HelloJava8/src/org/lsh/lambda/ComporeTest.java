package org.lsh.lambda;

import java.util.Arrays;

public class ComporeTest {
	public static void main(String[] args) {
		String[] words = { "aaa", "dddddd", "bbbb", "ccccc" };

		//���ݳ��ȱȴ�С
		Arrays.sort(words, (first, second) -> Integer.compare(first.length(), second.length()));
		for (String str : words) {
			System.out.println(str);
		}
	}
}
