package com.javaconcurrency.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import com.normal.samples.RandomGenerator;

public class ConcurrentMapUseCase {

	ConcurrentHashMap<String, String> originalKeyMap = new ConcurrentHashMap<>();
	ConcurrentHashMap<String, String> currentSessionKeyMap = new ConcurrentHashMap<>();

	Function<String, String> returnRandomNumber = (String inputString) -> {
		return new RandomGenerator().generateRandomNumber("0", "1000");
	};

	public boolean keyExistsOriginalKeyList(String key) {
		if (originalKeyMap.computeIfAbsent(key, returnRandomNumber) == null) {
			return true;
		} else
			return false;
	}

	public boolean keyExistsCurrentSessionMap(String key) {
		originalKeyMap.computeIfAbsent(key, s -> "90");
		Set<String> set = originalKeyMap.newKeySet();
		return true;
	}
	
	
	public ConcurrentHashMap<String, String> readCSV(String filePath) throws IOException,FileNotFoundException{
		
		File file = new File(filePath);
		InputStream inStream = new FileInputStream(file);
		Reader reader = new FileReader(file);
		BufferedReader buffreader = new BufferedReader(reader);
		String line = null;
		while((line = buffreader.readLine())!= null) {
			String[] arr = line.split(",");
			currentSessionKeyMap.putIfAbsent(arr[0], "somdefault");
		}
		return currentSessionKeyMap;
		
	}


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


	}

}
