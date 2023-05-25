package com.singleton;

public class MySingletonLazyReflectionAndThreadSafe {

	// solution 3. make volatile to avoid half read of variable state
	private volatile static MySingletonLazyReflectionAndThreadSafe mySingletonLazyReflectionAndThreadSafe;
	private MySingletonLazyReflectionAndThreadSafe() {
		if(mySingletonLazyReflectionAndThreadSafe != null)
			throw new RuntimeException();
	}
	// solution 1. make getInstance synchronized
	
	public static synchronized MySingletonLazyReflectionAndThreadSafe getInstance_v1() {
		if(mySingletonLazyReflectionAndThreadSafe != null)
			return mySingletonLazyReflectionAndThreadSafe;
		
		mySingletonLazyReflectionAndThreadSafe = new MySingletonLazyReflectionAndThreadSafe();
		return mySingletonLazyReflectionAndThreadSafe;
	}
	
	// solution 2. double check
	public static MySingletonLazyReflectionAndThreadSafe getInstance_v2() {
		if(mySingletonLazyReflectionAndThreadSafe == null) {
			synchronized (MySingletonLazyReflectionAndThreadSafe.class) {
				// below if check already existed from begening
				if(mySingletonLazyReflectionAndThreadSafe == null) {
					mySingletonLazyReflectionAndThreadSafe = new MySingletonLazyReflectionAndThreadSafe();
					return mySingletonLazyReflectionAndThreadSafe;
				}					
			}
		}
		return mySingletonLazyReflectionAndThreadSafe;
	}
	
	public static void main(String[] args) {
		Runnable r1 = () -> {
			MySingletonLazyReflectionAndThreadSafe instance1 = 
					MySingletonLazyReflectionAndThreadSafe.getInstance_v1();
			System.out.println(instance1.hashCode());
		};
		Runnable r2 = () -> {
			
			MySingletonLazyReflectionAndThreadSafe instance2 = 
					MySingletonLazyReflectionAndThreadSafe.getInstance_v1();
			System.out.println(instance2.hashCode());
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		/* If you run this code many times, you will see 
		 * sometimes both the threads creates different instances.*/
		t1.start();
		
		t2.start();
	}
}
