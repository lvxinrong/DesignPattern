package com.adapter.version.classAdapter;

public class Test {
	/**
	 * 核心思想就是：有一个Source类，拥有一个方法，待适配，目标接口时Targetable，
	 * 通过Adapter类，将Source的功能扩展到Targetable里
	 * 
	 * 具体的使用暂时不知道
	 */
	public static void main(String[] args) {  
        Targetable target = new Adapter();  
        target.method1();  
        target.method2();  
    }  
}
