package chapter6;

/**
 * Java里, 被final修饰的类无法被继承, 被final修饰的方法无法被重写(override)
 */
final class Base {
	public Base() {

	}
}

/**
 * Chapter6 Problem48 不能被继承的类
 */
public class NonExtendClass {

	public static void main(String[] args) {
		Base base = new Base();
	}
}
