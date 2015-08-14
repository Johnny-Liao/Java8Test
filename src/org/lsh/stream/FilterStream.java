package org.lsh.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilterStream {
	
	@SuppressWarnings({ "null", "unused" })
	public static void main(String[] args) {
		List<String> wordList = null;
		Stream<String> words = wordList.stream();
		Stream<String> longWords = words.filter(w -> w.length() > 12); // filter方法的参数是一个Predicate<T>对象，即一个从T到boolean的函数

		// 对流中的值进行某种转换，可以使用map方法
		Stream<String> lowercaseWords = words.map(String::toLowerCase); // map方法会对每个元素应用一个函数，并将返回值收集到一个新的流中
		Stream<Character> firstChars = words.map(s -> s.charAt(0));

		// wrong
		Stream<Stream<Character>> result = words.map(w -> characterStream(w));
		// right 将其展开为一个只包含字符串的流
		Stream<Character> letters = words.flatMap(w -> characterStream(w)); // 对每个单词调用characterStream并展开
	}

	public static Stream<Character> characterStream(String s) { // 函数：返回包含多个值的流
		List<Character> result = new ArrayList<>();
		for (char c : s.toCharArray())
			result.add(c);
		return result.stream();
	}
}
