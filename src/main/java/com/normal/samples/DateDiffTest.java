package com.normal.samples;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;

public class DateDiffTest {
	
	static void normalDateDiff(String dt1,String dt2) throws ParseException {
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date1 = format.parse(dt1);
		Date date2 = format.parse(dt2);
		
		System.out.println(date1.toString());
		System.out.println(date2.toString());
		
		long diff = date2.getTime() - date1.getTime();
		
		long days = diff/(1000 * 60 * 60 * 24);
		long seconds = diff/1000 % 60;
		long minutes = diff/(1000*60) % 60;
		long hours = diff/(1000*60*60) % 24;
		//long minutes = diff/1000*60       // 102 seconds -> 102%60 - 42 second and 1 minutes -- 102/60
		
		System.out.println("diff in days: "+ days + " diff in hours: "+ hours + " in minutes: "+ minutes + " in seconds: "+ seconds);
		
	}
	
	static void jodaDateDiff(String d1,String d2) throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date date1 = format.parse(d1);
		Date date2 = format.parse(d2);
		
		DateTime dt1 = new DateTime(date1);
		DateTime dt2 = new DateTime(date2);
		
		
		System.out.println(Days.daysBetween(dt1, dt2).getDays());
		System.out.println(Hours.hoursBetween(dt1, dt2).getHours()%24);
		System.out.println(Seconds.secondsBetween(dt1, dt2).getSeconds()%60);
		System.out.println(Minutes.minutesBetween(dt1, dt2).getMinutes()%60);		
		
	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String dateStart = "2012-01-14 09:29:58";
		String dateStop = "2012-01-15 10:31:48";
		normalDateDiff(dateStart,dateStop);
		jodaDateDiff(dateStart,dateStop);
		
	}

}
