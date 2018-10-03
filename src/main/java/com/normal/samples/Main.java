package com.normal.samples;

import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Supplier < Integer > supplier = () -> { return new Integer(null); };
		
		Option.Some<Integer> op = new Option.Some<Integer>(23);
		System.out.println(op.getOrElse(supplier));
		
		Outer outer = new Outer();
		Outer.nInner Niner = outer.new nInner();
		Niner.printMsg();
		
		
		Outer.Inner inner = new Outer.Inner();
		inner.display();

	}

}
