package org.lsh.lambda;

import java.util.Arrays;

/**
 * ����Ӧ�õ�ͬ���ṩ����������lambda���ʽ
 * ���֣�
 * 		����::ʵ������
 * 		��::��̬����
 * 		��::ʵ������	��	��һ���������Ϊִ�з����Ķ���
 * @author JohnnyLiao
 */
public class MethodRef {
	public static void main(String[] args) {
		String[] words = { "aaa", "dddddd", "bbbb", "ccccc" };
		Arrays.sort(words, String::compareToIgnoreCase);	//equals (x, y) -> x.compareToIgnoreCase(y)
		for (String str : words) {
			System.out.println(str);
		}
	}	
}
//���񷽷��е�this�������磺this::equals��ͬ�� x -> this.equals(x).
//Ҳ����ʹ��super�����磺super::ʵ������	��ʹ��this��Ϊ����ִ�еĶ���,�����ø�����ָ���ķ�����