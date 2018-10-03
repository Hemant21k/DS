package com.normal.samples;

public class Outer {
	
	public static String msg = "Inner Class Trial";
	public String nonstaticmsg = "non-static-mesg";
	
	static {
		msg = "static mesg changed in static block";
	}
	
	void printSomeMesg() {
		System.out.println("some mesg");
	}
	
	public static class Inner{
		
		void display() {
			System.out.println("messg from Inner Class :" + msg );
		}
	}
	
	public class nInner{
		void printMsg(){
			printSomeMesg();
			System.out.println("messg from NInner Class :" + nonstaticmsg );
		}
	}

}
