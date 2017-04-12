package com.singleton.version;
/**
 * 虽然SingleTon_4 暂时已经没有任何可以出错的地方了
 * 但是写法比较复杂，不是很优雅，所以这里再写一种 Effective java 1中的单列写法
 * 思路很牛逼的
 * @author Administrator
 *
 */
public class SingleTon_5 {
	/**
	 * 对于内部类SingleTonInstance，它是一个饿汉式的单例实现，在SingleTonInstance初始化的时候会由ClassLoader来保证同步，使INSTANCE是一个真·单例。
     * 同时，由于SingleTonInstance是一个内部类，只在外部类的SingleTon_5的getInstance()中被使用，所以它被加载的时机也就是在getInstance()方法第一次被调用的时候。
     * 它利用了ClassLoader来保证了同步，同时又能让开发者控制类加载的时机。从内部看是一个饿汉式的单例，但是从外部看来，又的确是懒汉式的实现。
	 *   简直是神乎其技。
	 */

	private static class SingleTonInstance {
		private static SingleTon_5 INSTANCE = new SingleTon_5();
	}
	
	public static SingleTon_5 getInstance() {
		return SingleTonInstance.INSTANCE;
	}
	
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */ 
	public Object readResolve() {  
        return getInstance();  
    }  
	/**
	 * 没有最完美的写法，只有最合适的写法，如果单线程情况下，那么第一种懒汉式就完全够用了，
	 * 学无止境吧
	 */
}
