package com.singleton.version;
/**
 * 当然不能忘了饿汉式，但是这种写法会造成不必要的加载
 * @author Administrator
 *
 */
public class SingleTon_7 {
	/**
	 * 因为实例实在类加载的时候就已经创建成功，所以不会造成懒汉式存在的并发问题，
	 * 但是这种写法有一个最大的问题就是无法延迟加载，如果单例的对象比较大，会造成不必要的浪费
	 * 个人觉得还是Effective java 1 中的 使用内部类来实现单例的写法比较好，无懈可击
	 * 对Java的类的加载机制的理解简直突破天际
	 */
	private static SingleTon_7 s = new SingleTon_7();
	
	public SingleTon_7 getInstance() {
		return s;
	}

}
