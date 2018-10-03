package com.io.tests;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SmallIOTests {
	
	public static void readUsingFileInputSteam(String path){
		File file = new File(path);
		byte[] b = new byte[6];
		try(FileInputStream fi = new FileInputStream(file)){
			int data = fi.read();
			while(data != -1) {
				System.out.println((char)data);
				data = fi.read();
			}
		}
		catch (IOException e) {
            System.out.println("Failed to read binary data from File");
		}	
		System.out.println("done!!!");
	}
	
	public static void readUsingFileReader(String path) {
		File file = new File(path);
		try(FileReader fr = new FileReader(file)){
			int data;
			while((data = fr.read()) != -1) {
				System.out.println((char)data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void readUsingBufferedFileReader(String path) throws FileNotFoundException, IOException {
		File file = new File(path);
		try(BufferedReader br = new BufferedReader(new FileReader(file)))  {
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
		}
	}
		catch(FileNotFoundException e){
			
		}
		catch(IOException e) {
			
		}
	}
	
	public static void readUsingScanner(String path) throws FileNotFoundException {
		File file = new File(path);
		FileInputStream fi = new FileInputStream(path);
		try(Scanner sc = new Scanner(fi)){
			while(sc.hasNextInt()) {
				System.out.println(sc.nextInt());
			}
		}
		
	}
	
	public static void writeUsingBufferedWriter(String path) throws IOException {
		Map<String,String> map = new HashMap<String,String>();
		map.put("key", "value");
		map.put("key1", "value");
		map.put("key2", "value");
		map.put("key3", "value");
		
		try(BufferedWriter bw = new BufferedWriter(new PrintWriter(path))){
			map.forEach((k, v) -> {
				try {
					bw.write((k + ":" + v));
					bw.write("\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			
			bw.flush();
			bw.close();
		}
		
		 //map.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
		 
/*		 for(Map.Entry<String, String> mp : map.entrySet()) {
			 System.out.println(mp.getValue() + ":" + mp.getKey());
		 }*/
		
		 Iterator<Map.Entry<String,String>> itr = map.entrySet().iterator();
		 while(itr.hasNext()) {
			 Entry<String,String> l = itr.next();
			 System.out.println(l.getKey() + ":" + l.getValue());
		 }
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		//readUsingFileReader("D:\\test.csv");
		//readUsingBufferedFileReader("D:\\test.csv");
		//readUsingScanner("D:\\test.csv");
		writeUsingBufferedWriter("D:\\example.txt");
		
	}

}

