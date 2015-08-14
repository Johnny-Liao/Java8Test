package org.lsh.lambda;

/**
 * һ��lambda���ʽ���������֣�
 * 	1. һ�δ���
 * 	2. ����
 * 	3. ���ɱ�����ֵ��"����"ָ������Щ���ǲ�������û���ڴ����ж���ı���
 *  @author JohnnyLiao
 *	�������ɱ����Ĵ���鱻��Ϊ�հ�(closure)��lambda���ʽ �� �ڲ���
 */
public class VariableScope {
	public static void repeatMessage(String text, int count) {		//���ɱ���	//�����ñ�����ֵ�������޸�
		Runnable r = () -> {
			for (int i = 0; i < count; i++) {
				System.out.println(text);
//				Thread.yield();
			}
		};
		new Thread(r).start();
	}

	public static void main(String[] args) {
		repeatMessage("Hello", 10);
	}

}
