package com.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MySingletonLazyReflectionSafe {

	private static MySingletonLazyReflectionSafe mySingletonReflectionSafe;
	private MySingletonLazyReflectionSafe() {
		// reflection safe code
		//To prevent Singleton failure while due to reflection you have to
		//throw a run-time exception in constructor, if the constructor is already initialized 
		//and some class to initialize it again
		if(mySingletonReflectionSafe != null)
			throw new RuntimeException();
	}
	
	public static MySingletonLazyReflectionSafe getInstance() {
		if(mySingletonReflectionSafe != null)
			return mySingletonReflectionSafe;
		
		mySingletonReflectionSafe = new MySingletonLazyReflectionSafe();
		return mySingletonReflectionSafe;
	}
	
	public static void main(String[] args) {
        //Create the 1st instance
		MySingletonLazyReflectionSafe instance1 = MySingletonLazyReflectionSafe.getInstance();
        
        //Create 2nd instance using Java Reflection API.
		MySingletonLazyReflectionSafe instance2 = null;
        try {
            Class<MySingletonLazyReflectionSafe> clazz = MySingletonLazyReflectionSafe.class;
            Constructor<MySingletonLazyReflectionSafe> cons = clazz.getDeclaredConstructor();
            cons.setAccessible(true);
            instance2 = cons.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        MySingletonLazyReflectionSafe instance3 = MySingletonLazyReflectionSafe.getInstance();
        
        //now lets check the hash key.
        System.out.println("Instance 1 hash:" + instance1.hashCode());
        try {
			System.out.println("Instance 2 hash:" + instance2.hashCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Instance 3 hash:" + instance3.hashCode());

	}
}
