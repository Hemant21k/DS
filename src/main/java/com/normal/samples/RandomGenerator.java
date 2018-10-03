package com.normal.samples;
import java.math.BigInteger;
import java.util.Random;

public class RandomGenerator {

	public String generateRandomNumber(String maxValue,String minValue) {
	    BigInteger bigInteger = new BigInteger(maxValue);// uper limit
	    BigInteger min = new BigInteger(minValue);// lower limit
	    BigInteger bigInteger1 = bigInteger.subtract(min);
	    Random rnd = new Random();
	    int maxNumBitLength = bigInteger.bitLength();

	    BigInteger aRandomBigInt;

	    aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
	    if (aRandomBigInt.compareTo(min) < 0)
	      aRandomBigInt = aRandomBigInt.add(min);
	    if (aRandomBigInt.compareTo(bigInteger) >= 0)
	      aRandomBigInt = aRandomBigInt.mod(bigInteger1).add(min);
	    
	    return aRandomBigInt.toString();
	}

	  public static void main(String[] args) {
	    BigInteger bigInteger = new BigInteger("9999999999999999999999");// uper limit
	    BigInteger min = new BigInteger("1000000000000000000001");// lower limit
	    BigInteger bigInteger1 = bigInteger.subtract(min);
	    Random rnd = new Random();
	    int maxNumBitLength = bigInteger.bitLength();

	    BigInteger aRandomBigInt;

	    aRandomBigInt = new BigInteger(maxNumBitLength, rnd);
	    if (aRandomBigInt.compareTo(min) < 0)
	      aRandomBigInt = aRandomBigInt.add(min);
	    if (aRandomBigInt.compareTo(bigInteger) >= 0)
	      aRandomBigInt = aRandomBigInt.mod(bigInteger1).add(min);
	    
	    System.out.println(aRandomBigInt);
	  }
	}

