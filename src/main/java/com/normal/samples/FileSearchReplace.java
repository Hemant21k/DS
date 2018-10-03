package com.normal.samples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

/*
 * https://www.dreamincode.net/forums/topic/39690-reading-from-specific-line-in-text-file/
 * https://dzone.com/articles/java-8-concurrenthashmap-atomic-updates?fromrel=true
 * https://dzone.com/articles/concurrenthashmap-isnt-always-enough
 * https://stackoverflow.com/questions/36827482/how-to-use-concurrenthashmap-computeifabsent-in-scala
 * https://blog.pythian.com/spark-udf-memoization/
 */

public class FileSearchReplace {
	protected void  processLine(
		PrintWriter writer, int lineNumber, String line		
		) throws IOException 
	{
		writer.println(line);
	}
		
	private void process(Reader readerBase, Writer writerBase) throws IOException {
		int currentLineNo = 0;
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(readerBase);
			writer = new PrintWriter(writerBase);
			String lineIn = null;
			while ((lineIn = reader.readLine()) != null) {
				processLine(writer, ++currentLineNo, lineIn);
			}
		} finally {
			try { if (reader!=null) reader.close(); } catch(IOException fex1) {}
			writer.close();
		}
	}
	

	public void process(String inFileName, String outFileName) {
		try {
			process(new FileReader(inFileName), new FileWriter(outFileName));
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public void processInFile(String fileName) {
		try {
			File inFile = new File(fileName);
			File tempFile = File.createTempFile("srtmp", "txt");
			process(inFile.getPath(), tempFile.getPath());
			inFile.delete();
			tempFile.renameTo(inFile);
			tempFile.delete();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	public void processToConsole(String fileName) {
		try {
			process(new FileReader(fileName), new OutputStreamWriter(System.out));
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
}

