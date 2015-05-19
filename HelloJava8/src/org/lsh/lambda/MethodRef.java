package org.lsh.lambda;

import java.util.Arrays;

/**
 * 方法应用等同于提供方法参数的lambda表达式
 * 三种：
 * 		对象::实例方法
 * 		类::静态方法
 * 		类::实例方法	：	第一个参数会成为执行方法的对象
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
//捕获方法中的this参数。如：this::equals等同于 x -> this.equals(x).
//也可以使用super对象。如：super::实例方法	会使用this作为方法执行的对象,并调用父类中指定的方法。