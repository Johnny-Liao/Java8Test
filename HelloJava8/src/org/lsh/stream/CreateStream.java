package org.lsh.stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.stream.Stream;

//��ʾ����Stream�Ĳ�ͬ����
public class CreateStream {
	public static void main(String[] args) throws IOException {
		String contents = null;

		// ������ת��ΪStream
		Stream<String> words = Stream.of(contents.split("[\\P{L}]+")); // split����������һ������

		// of�������ܿɱ����
		Stream<String> song = Stream.of("gently", "down", "the", "stream");
		 Iterator it = song.iterator();
		 while (it.hasNext()) {
			 System.out.println(it.next());
		 }
		
		//������һ����ת��ΪStream
		Arrays.stream(contents.split("[\\P{L}]+"), 1, 2);
		
		//������Stream
		Stream<String> silence = Stream.empty();	//����<String>�ᱻ�������Ƶ�����
		
		/**
		 * Stream�ӿ�������������������Stream�ľ�̬������generate/iterate
		 * 	generate���������ܸ��޲����ĺ���(��һ��Supplier<T>�ӿڵĶ���)��������Ҫһ��ֵ�Ϳ��Ե��ø÷�������һ��ֵ��
		 * 	iterate��������������1,2,3...���������С�����һ�����Ӻͺ���(UnaryOperator<T>�ӿڵĶ���)��Ϊ�����������֮ǰ��ֵ�ظ�Ӧ�øú�����
		 */
		//generate: �ֱ𴴽����г���ֵ���������Stream
		Stream<String> echos = Stream.generate(() -> "Echo");
		Stream<Double> randoms = Stream.generate(Math::random);
		//iterate
		Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
		
		//��һ���ַ������յ��ʽ��зָ�
		Stream<String> patternWords = Pattern.compile("[\\P{L}]+").splitAsStream(contents);
		
		// Files.lines ����һ�������ļ��������е�Stream.		try-with-resource
		try (Stream<String> lines = Files.lines(null)) {
			//��lines����һЩ����
		}
		
	}
}
