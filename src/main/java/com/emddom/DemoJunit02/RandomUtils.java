package com.emddom.DemoJunit02;


//package org.rulez.demokracia.pdengine;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

final public class RandomUtils {
    private static SecureRandom entropySource;
    
    final static SecureRandom defaultRandom = new SecureRandom();

    private static final Logger LOGGER = Logger.getLogger( RandomUtils.class.getName() );

    private RandomUtils() {
    	initializeEntropySource();
    }

	public static String createRandomKey() {
		initializeEntropySource();
		return Long.toHexString(entropySource.nextLong());
	}

	private static void initializeEntropySource() {
	   	LOGGER.log(Level.INFO, "from initializeEntropySource");

		if(null == entropySource) {
			try {
// https://stackoverflow.com/questions/27622625/securerandom-with-nativeprng-vs-sha1prng				
				entropySource=SecureRandom.getInstance("SHA1PRNG");
			   	System.out.println("ran SecureRandom.getInstance");
			   	LOGGER.log(Level.INFO, "from initializeEntropySource within try");
			} catch (NoSuchAlgorithmException e) {
				LOGGER.log(Level.SEVERE, "no SHA1PRNG random implementation", e);
				System.exit(-1);
			}
		}
	}
	
	public static void showDefaultRandomAlgorithm() {
		System.out.println("defaultRandom algorithm = " + defaultRandom.getAlgorithm());
		// prints "defaultRandom algorithm = NativePRNG"
		
	}

	
	
}