package org.lsh.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilterStream {
	
	@SuppressWarnings({ "null", "unused" })
	public static void main(String[] args) {
		List<String> wordList = null;
		Stream<String> words = wordList.stream();
		Stream<String> longWords = words.filter(w -> w.length() > 12); // filter�����Ĳ�����һ��Predicate<T>���󣬼�һ����T��boolean�ĺ���

		// �����е�ֵ����ĳ��ת��������ʹ��map����
		Stream<String> lowercaseWords = words.map(String::toLowerCase); // map�������ÿ��Ԫ��Ӧ��һ����������������ֵ�ռ���һ���µ�����
		Stream<Character> firstChars = words.map(s -> s.charAt(0));

		// wrong
		Stream<Stream<Character>> result = words.map(w -> characterStream(w));
		// right ����չ��Ϊһ��ֻ�����ַ�������
		Stream<Character> letters = words.flatMap(w -> characterStream(w)); // ��ÿ�����ʵ���characterStream��չ��
	}

	public static Stream<Character> characterStream(String s) { // ���������ذ������ֵ����
		List<Character> result = new ArrayList<>();
		for (char c : s.toCharArray())
			result.add(c);
		return result.stream();
	}
}
