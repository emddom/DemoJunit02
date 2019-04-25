package com.emddom.DemoJunit02;

import java.lang.reflect.Field;

import com.emddom.DemoJunit02.RandomUtils;

import java.security.NoSuchAlgorithmException;
//import java.security.SecureRandom;
//import java.util.logging.Level;
//import java.util.logging.Logger;

//import org.rulez.demokracia.pdengine.RandomUtils;



public class SetEntropy {
	
	// class ShowProperties 
	// https://stackoverflow.com/questions/228477/how-do-i-programmatically-determine-operating-system-in-java
	// https://stackoverflow.com/questions/31909107/javas-os-name-for-windows-10
	public static void main(String[] args) {
		System.out.println( System.getProperty("os.name") );
//		System.getProperties().list(System.out);
		
		if (System.getProperty("os.name").toLowerCase().contains("windows") ){
			System.out.println("contains string: windows" );
		}
		
		RandomUtils.createRandomKey();
// https://www.intertech.com/Blog/a-static-method-should-be-accessed-in-a-static-way/		
		RandomUtils.showDefaultRandomAlgorithm();
	
//		setStaticValue(final String className, final String fieldName, final Object newValue)
//		setStaticValue(RandomUtils, final String fieldName, final Object newValue)

	}


	
}


