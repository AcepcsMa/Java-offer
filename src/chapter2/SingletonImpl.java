package chapter2;

/**
 * 饿汉式实现
 */
class Singleton1 {

	private static final Singleton1 INSTANCE = new Singleton1();

	private Singleton1() {

	}

	public static Singleton1 getInstance() {
		return INSTANCE;
	}
}

/**
 * 普通懒汉式实现
 */
class Singleton2 {

	private static Singleton2 instance;

	private Singleton2() {

	}

	public static Singleton2 getInstance() {
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}
}

/**
 * 懒汉式+双重校验锁
 */
class Singleton3 {
	private static volatile Singleton3 instance;

	private Singleton3() {

	}

	public static Singleton3 getInstance() {
		if (instance == null) {
			synchronized(Singleton3.class) {
				if (instance == null) {
					instance = new Singleton3();
				}
			}
		}
		return instance;
	}
}

/**
 * 静态内部类实现
 */
class Singleton4 {

	private static class SingletonHandler {
		private static final Singleton4 INSTANCE = new Singleton4();
	}

	private Singleton4() {

	}

	public static Singleton4 getInstance() {
		return SingletonHandler.INSTANCE;
	}
}

/**
 * Chapter2 Problem2 实现单例模式
 * @author Marco Ma
 */
public class SingletonImpl {

	public static void main(String[] args) {
		Singleton1 instance1_1 = Singleton1.getInstance();
		Singleton1 instance1_2 = Singleton1.getInstance();
		System.out.println(instance1_1 == instance1_2);

		Singleton2 instance2_1 = Singleton2.getInstance();
		Singleton2 instance2_2 = Singleton2.getInstance();
		System.out.println(instance2_1 == instance2_2);

		Singleton3 instance3_1 = Singleton3.getInstance();
		Singleton3 instance3_2 = Singleton3.getInstance();
		System.out.println(instance3_1 == instance3_2);

		Singleton4 instance4_1 = Singleton4.getInstance();
		Singleton4 instance4_2 = Singleton4.getInstance();
		System.out.println(instance4_1 == instance4_2);

	}
}
