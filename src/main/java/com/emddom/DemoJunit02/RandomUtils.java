package com.emddom.DemoJunit02;


//package org.rulez.demokracia.pdengine;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

final public class RandomUtils {
    private static SecureRandom entropySource;
    
    final SecureRandom defaultRandom = new SecureRandom();

    private static final Logger LOGGER = Logger.getLogger( RandomUtils.class.getName() );

    private RandomUtils() {
    }

	public static String createRandomKey() {
		initializeEntropySource();
		return Long.toHexString(entropySource.nextLong());
	}

	private static void initializeEntropySource() {
		if(null == entropySource) {
			try {
				entropySource=SecureRandom.getInstance("SHA1PRNG");
			} catch (NoSuchAlgorithmException e) {
				LOGGER.log(Level.SEVERE, "no SHA1PRNG random implementation", e);
				System.exit(-1);
			}
		}
	}
	
	public void showDefaultRandomAlgorithm() {
		System.out.println("defaultRandom algorithm = " + defaultRandom.getAlgorithm());
		// prints "defaultRandom algorithm = NativePRNG"
	}

	
	
}