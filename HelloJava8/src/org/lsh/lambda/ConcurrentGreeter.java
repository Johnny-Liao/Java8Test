package org.lsh.lambda;

//捕获方法中的this参数。如：this::equals等同于 x -> this.equals(x).
//也可以使用super对象。如：super::实例方法	会使用this作为方法执行的对象,并调用父类中指定的方法。

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
