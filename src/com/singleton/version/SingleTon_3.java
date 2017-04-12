package com.singleton.version;
/**
 * 枷锁粒度稍小的同步方法
 * @author Administrator
 *  
 */
public class SingleTon_3 {
	
	private static SingleTon_3 s;
	
	private SingleTon_3(){}
	
	public SingleTon_3 getInstance() {
		if(s == null) {
			synchronized(SingleTon_3.class) {
				if(s == null)
					//但是这里依然会出现极端情况下，多线程的情况下
					//s = new SingleTon_3();的操作不是原子操作，可能会发生指令重排
					/**
					 * 主要在于singleton = new Singleton()这句，这并非是一个原子操作，事实上在 JVM 中这句话大概做了下面 3 件事情。
					 * 1给 singleton 分配内存
					 * 2调用 Singleton 的构造函数来初始化成员变量，形成实例
					 * 3将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null 了）
					 * 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
					 */
					s = new SingleTon_3();
			}
		}
		return s;
	}

}
