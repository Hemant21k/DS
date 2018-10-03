package com.ds.examples;

public class ConvertToBaseN {
	
	static String findBase2(int a,String n) {
		
		if(a == 1)
			return String.valueOf(1)+n;
		
		int q = a/2;
		int r = a%2;
		
		if(n.length() == 0) {
			n = String.valueOf(r);
		} else {
			n = r+n;
		}
		
		return findBase2(q,n);
	}
	
	public static String findDigitsInBinary(int A) {
	String str1="";	
	String str = findBase2(A,str1);	
		return str;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findDigitsInBinary(9));
		String str="";
		System.out.println(str.length());
	}

}
