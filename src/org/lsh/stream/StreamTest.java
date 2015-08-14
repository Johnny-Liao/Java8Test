package org.lsh.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Stream借鉴了linux的流的思想
public class StreamTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		// 将文件读取到字符串中
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		// Old method.
		int count = 0;
		for (String w : words) {
			if (w.length() > 12)
				count++;
		}

		// In java8：比循环可读性更好，还很容易执行并行执行
		long count2 = words.stream().filter(w -> w.length() > 12).count();

		// 并行执行
		long count3 = words.parallelStream().filter(w -> w.length() > 12).count();

		/**
		 * 三个阶段来建立操作流水线：<br>
		 * 1.创建一个Stream.<br>
		 * 2.在一个或多个步骤中，指定将初始Stream转换为另一个Stream的中间操作.<br>
		 * 3.使用终止操作来产生一个结果.该操作会强制它之前的延迟操作立即执行.这之后，该Stream就不会再被使用.<br>
		 */

		// 将数组转换为Stream
		Stream<String> words2 = Stream.of(contents.split("[\\P{L}]+")); // split方法将返回一个数组
	}
}
