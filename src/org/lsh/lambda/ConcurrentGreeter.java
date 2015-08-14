package org.lsh.lambda;

//���񷽷��е�this�������磺this::equals��ͬ�� x -> this.equals(x).
//Ҳ����ʹ��super�����磺super::ʵ������	��ʹ��this��Ϊ����ִ�еĶ���,�����ø�����ָ���ķ�����

class Greeter {
	public void greeter() {
		System.out.println("Hello, world! " + this);
	}
}

public class ConcurrentGreeter extends Greeter {
	public void greeter() {
		Thread t = new Thread(super::greeter);
		t.start();
	}

	public static void main(String[] args) {
		new ConcurrentGreeter().greeter();
	}
}
