# DesignPattern

* 这个库用于自己学习设计模式建的，一直没有把自己的理解整理出来所以整理一下

### 单例模式 
__单例模式，个人对单例的最大的体会就是构造器的私有，保证外部无法创建类的实例，保证了在系统中只存在唯一的一个实体对象。比如数据库的连接池，多线程的线程池
目的是减少大对象的创建销毁过程中造成的资源损耗。或者说方便类对创建对象的控制比如线程池__
* 单例模式一共收集到七中写法，因为很少会有单线程下的单例的使用，所以基本上都都要考虑到多线程，并发时候，单例的创建。恶汉式在某种程度上是解决了并发的问题
但是如果说所创建的对象非常大，采用恶汉式就会在系统启动的时候造成不必要的浪费，所以一般的写法都是在基础懒汉式的模式上进行改造，比如synchornized的加锁，
可以看com.singleton.version.SingleTon_2的写法，直接在获取实例的方法上进行加锁。这样的写法虽然说解决了并发安全的问题，但是因为锁的粒度相对而言还是比较大
因为判断实例是否为null的操作是没有必要放在锁中的，因为有了第三种写法,SingleTon_3的写法就是减小锁的粒度，但是（我在学习单例的时候看到但是就内心一颤，卧槽
都特么写成这样了也不行，继续看）因为new的过程中，可能会产生指令重排，new的过程分为三步，1给 SingleTon分配内存，2调用SingleTon的构造函数生成实例 3，
将singleton对象指向分配的内存空间（执行完这步 singleton才是非 null 了），因为singleTon没有声明为voliate的类型，这里可能会3在2之前发生，也就是说这个时候
如果再有一个线程来获取实例，可能会返回null，这时，就有了voliate去声明这个唯一的单例，产生了第四种单例的写法 SingleTon_4.其实这种写法，在使用上已经没有
问题了(反正我不打包票，谁知道以后会怎么样呢)但是写法不优雅，不好看。哈哈哈，果然给了我一种永无止境的感觉，感觉贼high。
这里提出了第五种写法，是出现在Effective Java 中，作者提出的一种单例写法，看完之后，叹为观止。思路就是恶汉式和懒汉是的结合，创建一个内部类，内部类中采用
饿汉式返回实例，但是在外部类的获取实例方法来看又是懒汉式，并且内部类是静态的，也就是说通过ClassLoader来保证同步。不行了，我要把这段代码放出来:
'''
public class SingleTon_5 {
	/**
	 * 对于内部类SingleTonInstance，它是一个饿汉式的单例实现，在SingleTonInstance初始化的时候会由ClassLoader来保证同步，使INSTANCE是一个真·单例。
     * 同时，由于SingleTonInstance是一个内部类，只在外部类的SingleTon_5的getInstance()中被使用，所以它被加载的时机也就是在getInstance()方法第一次被调用的时候。
     * 它利用了ClassLoader来保证了同步，同时又能让开发者控制类加载的时机。从内部看是一个饿汉式的单例，但是从外部看来，又的确是懒汉式的实现。
	 *   简直是神乎其技。
	 */
	private static class SingleTonInstance {
		//这里如果抛出异常，则会导致得不到实例
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
'''
