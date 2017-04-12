package com.singleton.version;

/**
 *                  最简单的一种懒汉式写法
 *私有（private）的构造函数，表明这个类是不可能形成实例了。这主要是怕这个类会有多个实例。
 *即然这个类是不可能形成实例，那么，我们需要一个静态的方式让其形成实例：getInstance()。
 *注意这个方法是在new自己，因为其可以访问私有的构造函数，所以他是可以保证实例被创建出来的。
 *在getInstance()中，先做判断是否已形成实例，如果已形成则直接返回，否则创建实例。
 *所形成的实例保存在自己类中的私有成员中。
 *我们取实例时，只需要使用Singleton.getInstance()就行了。
 */
public class SingleTon_1 {
	
	private static SingleTon_1 s = null;
	
	private SingleTon_1(){}
	
	public SingleTon_1 getInstance() {
		if(s == null) 
			s = new SingleTon_1();
		return s;
	}

}
