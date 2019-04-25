package com.emddom.DemoJunit02;

import java.lang.reflect.Field;

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
    }

	public static String createRandomKey() {
		initializeEntropySource();
		return Long.toHexString(entropySource.nextLong());
	}
	
	
    /**
     * Returns an object containing the value of any field of an object instance (even private).
     * @param classInstance An Object instance.
     * @param fieldName The name of a field in the class instantiated by classInstance
     * @return An Object containing the field value.
     * @throws SecurityException .
     * @throws NoSuchFieldException .
     * @throws ClassNotFoundException .
     * @throws IllegalArgumentException .
     * @throws IllegalAccessException .
     */
    public static Object getInstanceValue(final Object classInstance, final String fieldName) throws SecurityException, NoSuchFieldException,
	    ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
	// Get the private field
	final Field field = classInstance.getClass().getDeclaredField(fieldName);
	// Allow modification on the field
	field.setAccessible(true);
	// Return the Obect corresponding to the field
	return field.get(classInstance);
    }
    
	public static void showDefaultRandomAlgorithm() {
		System.out.println("defaultRandom algorithm = " + defaultRandom.getAlgorithm());
		// prints "defaultRandom algorithm = NativePRNG"
		System.out.println("entropySource algorithm = " + entropySource.getAlgorithm());
		try {
			getInstanceValue(entropySource, "algorithm");
		} catch (SecurityException se) {
		} catch (NoSuchFieldException nsfe) {
		} catch (ClassNotFoundException cnfe) {
		} catch (IllegalArgumentException iae) {
		} catch (IllegalAccessException iae) {
		}
	}


    
	

	private static void initializeEntropySource() {
	   	LOGGER.log(Level.INFO, "from initializeEntropySource");

		if(null == entropySource) {
			try {
// https://stackoverflow.com/questions/27622625/securerandom-with-nativeprng-vs-sha1prng
// SecureRandom Number Generation Algorithms: 
// https://docs.oracle.com/en/java/javase/11/docs/specs/security/standard-names.html#securerandom-number-generation-algorithms
// DRBG SHA1PRNG NativePRNG				
				entropySource=SecureRandom.getInstance("SHA1PRNG");
			   	LOGGER.log(Level.INFO, "ran SecureRandom.getInstance from initializeEntropySource within try");   	
			} catch (NoSuchAlgorithmException e) {
				LOGGER.log(Level.SEVERE, "NoSuchAlgorithmException", e);
				System.exit(-1);
			}
			
			
		}
	}
	
	
	

}