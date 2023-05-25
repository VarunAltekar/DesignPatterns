package com.singleton;

import java.io.Serializable;

public class MySingletonLazyReflectionThreadSafeSerSafe implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private volatile static MySingletonLazyReflectionThreadSafeSerSafe mySingletonLazyReflectionThreadSafeSerSafe;
	private MySingletonLazyReflectionThreadSafeSerSafe() {
		if(mySingletonLazyReflectionThreadSafeSerSafe != null)
			throw new RuntimeException();
	}
	
	public static MySingletonLazyReflectionThreadSafeSerSafe getInstance() {
		if(mySingletonLazyReflectionThreadSafeSerSafe == null) {
			synchronized (MySingletonLazyReflectionThreadSafeSerSafe.class) {
				if(mySingletonLazyReflectionThreadSafeSerSafe == null) {
					mySingletonLazyReflectionThreadSafeSerSafe = new MySingletonLazyReflectionThreadSafeSerSafe();
					return mySingletonLazyReflectionThreadSafeSerSafe;
				}
			}
		}		
		return mySingletonLazyReflectionThreadSafeSerSafe;	
	}

	// makes singleton serialization / de serialization safe
	protected MySingletonLazyReflectionThreadSafeSerSafe readResolve() {
		return getInstance();
	}
}
