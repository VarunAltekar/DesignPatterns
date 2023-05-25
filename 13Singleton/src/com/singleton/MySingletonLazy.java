package com.singleton;

public class MySingletonLazy {

	private static MySingletonLazy mySingletonLazy;
	private MySingletonLazy() {}
	
	public static MySingletonLazy getInstance() {
		if(mySingletonLazy != null)
			return mySingletonLazy;
		
		mySingletonLazy = new MySingletonLazy();
		return mySingletonLazy;
	}
	
	public static void main(String[] args) {
		MySingletonLazy i1 = MySingletonLazy.getInstance();
		MySingletonLazy i2 = MySingletonLazy.getInstance();
		
	    // same objects have same hash code
		System.out.println(i1.hashCode());
		System.out.println(i2.hashCode());
	}
}
