package org.lsh.lambda;

/**
 * 一个lambda表达式包含三部分：
 * 	1. 一段代码
 * 	2. 参数
 * 	3. 自由变量的值："自由"指的是那些不是参数并且没有在代码中定义的变量
 *  @author JohnnyLiao
 *	含有自由变量的代码块被称为闭包(closure)：lambda表达式 和 内部类
 */
public class VariableScope {
	public static void repeatMessage(String text, int count) {		//自由变量	//被引用变量的值不可以修改
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
