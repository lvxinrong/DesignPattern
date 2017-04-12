package com.singleton.version;

public class SingleTon_4 {
	
	private static volatile SingleTon_4 s;
	
	private SingleTon_4(){}
	
	public SingleTon_4 getInstance() {
		if(s == null) {
			synchronized(SingleTon_4.class) {
				if(s == null)
					/**
					 * volatile关键字的一个作用是禁止指令重排，把instance声明为volatile之后，
					 * 对它的写操作就会有一个内存屏障（什么是内存屏障？），
					 * 这样，在它的赋值完成之前，就不用会调用读操作。
					 */
					s = new SingleTon_4();
			}
		}
		return s;
	}

}
