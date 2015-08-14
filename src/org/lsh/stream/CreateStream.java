package org.lsh.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.stream.Stream;

//演示创建Stream的不同方法
public class CreateStream {
	@SuppressWarnings({ "unused", "null", "rawtypes" })
	public static void main(String[] args) throws IOException {
		String contents = null;

		// 将数组转换为Stream
		Stream<String> words = Stream.of(contents.split("[\\P{L}]+")); // split方法将返回一个数组

		// of方法接受可变参数
		Stream<String> song = Stream.of("gently", "down", "the", "stream");
		Iterator it = song.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// 将数组一部分转换为Stream
		Arrays.stream(contents.split("[\\P{L}]+"), 1, 2);

		// 创建空Stream
		Stream<String> silence = Stream.empty(); // 泛型<String>会被编译器推导出来

		/**
		 * Stream接口有两个用来创建无限Stream的静态方法：generate/iterate
		 * generate方法：接受个无参数的函数(是一个Supplier<T>接口的对象)，当你需要一个值就可以调用该方法产生一个值。
		 * iterate方法：创建形如1,2,3...的无限序列。接受一个种子和函数(UnaryOperator<T>接口的对象)作为参数，
		 * 并会对之前的值重复应用该函数。
		 */
		// generate: 分别创建含有常量值和随机数的Stream
		Stream<String> echos = Stream.generate(() -> "Echo");
		Stream<Double> randoms = Stream.generate(Math::random);
		// iterate
		Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));

		// 对一个字符串按照单词进行分隔
		Stream<String> patternWords = Pattern.compile("[\\P{L}]+").splitAsStream(contents);

		// Files.lines 返回一个包含文件中所有行的Stream. try-with-resource
		try (Stream<String> lines = Files.lines(null)) {
			// 对lines进行一些处理
		}

	}
}
