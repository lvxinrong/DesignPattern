package com.singleton.version;
/**
 * 线程安全的 SingleTon 写法 1.0
 * @author Administrator
 *
 */
public class SingleTon_2 {
	
	private static SingleTon_2 s;
	
	private SingleTon_2(){}
	/**
	 * 这里需要同步的其实只是当s == null 的时候，所以，没必要枷锁粒度在整个方法上，
	 * @return
	 */
	public synchronized SingleTon_2 getInstance() {
		if(s == null) 
			s = new SingleTon_2();
		return s;
	}

}
