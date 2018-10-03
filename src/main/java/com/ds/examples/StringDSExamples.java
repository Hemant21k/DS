package com.ds.examples;

public class StringDSExamples {

	static void calculatePermutes(String part, String rest) {
		if (rest.length() == 0)
			System.out.println("permuted string: "+ part);

		for (int i = 0; i < rest.length(); i++) {
			if(findDuplicates(rest,i))
				continue;
			String part1 = part + String.valueOf(rest.charAt(i));
			String rest1 = rest.substring(0, i) + rest.substring(i + 1);
			calculatePermutes(part1, rest1);
			}
		}
	
	static boolean findDuplicates(String str,int start) {
		if(str.substring(start+1).contains(String.valueOf(str.charAt(start))))
			return true;
		else
			return false;
	}

	static void StringPermutes(String str) {
		calculatePermutes("", str);
	}
	
	static int calculateCombinations(int k,int n) {
		if(k == 0 || k == n)
			return 1;
		
		int total = calculateCombinations(k,n-1) + calculateCombinations(k-1,n-1);
		
		return total;
		
	}
	
	static long calcBasePow(int base,int pow) {
		if(pow == 0)
			return 1;
		
		long exp = base * calcBasePow(base,pow-1);
		return exp;
	}

	
	public static void main(String[] args) {
		//
		StringPermutes("DFF");
		
		//System.out.println(calcBasePow(2,40));
	}

}
