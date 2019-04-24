package com.emddom.DemoJunit02;

import com.emddom.DemoJunit02.RandomUtils.*;


public class App 
{
	static Calculator myCalculator = new Calculator() ;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.print(myCalculator.add(2,3));
	
    }
}
