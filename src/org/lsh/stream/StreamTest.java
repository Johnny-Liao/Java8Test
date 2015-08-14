package org.lsh.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Stream�����linux������˼��
public class StreamTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		// ���ļ���ȡ���ַ�����
		String contents = new String(Files.readAllBytes(Paths.get("alice.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

		// Old method.
		int count = 0;
		for (String w : words) {
			if (w.length() > 12)
				count++;
		}

		// In java8����ѭ���ɶ��Ը��ã���������ִ�в���ִ��
		long count2 = words.stream().filter(w -> w.length() > 12).count();

		// ����ִ��
		long count3 = words.parallelStream().filter(w -> w.length() > 12).count();

		/**
		 * �����׶�������������ˮ�ߣ�<br>
		 * 1.����һ��Stream.<br>
		 * 2.��һ�����������У�ָ������ʼStreamת��Ϊ��һ��Stream���м����.<br>
		 * 3.ʹ����ֹ����������һ�����.�ò�����ǿ����֮ǰ���ӳٲ�������ִ��.��֮�󣬸�Stream�Ͳ����ٱ�ʹ��.<br>
		 */

		// ������ת��ΪStream
		Stream<String> words2 = Stream.of(contents.split("[\\P{L}]+")); // split����������һ������
	}
}
