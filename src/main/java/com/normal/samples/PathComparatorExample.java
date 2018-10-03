package com.normal.samples;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class PathComparatorExample implements Comparable<PathComparatorExample>{

	private String path;

	private Date date;

	public PathComparatorExample(Date date,String path) {
		this.path = path;
		this.date = date;
	}
	
	@Override
	public int compareTo(PathComparatorExample o1) {	
		return this.date.compareTo(o1.date);
	}
	
	public static Comparator<PathComparatorExample> dateComparator = new Comparator<PathComparatorExample>(){

		@Override
		public int compare(PathComparatorExample o1, PathComparatorExample o2) {
			// TODO Auto-generated method stub
			return o1.date.compareTo(o2.date);
		}
		
	};

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PathComparatorExample p1 = new PathComparatorExample(new Date(System.currentTimeMillis()),"some/path1");
		PathComparatorExample p2 = new PathComparatorExample(new Date(System.currentTimeMillis()+864000),"some/path2");
		PathComparatorExample p3 = new PathComparatorExample(new Date(System.currentTimeMillis()+2*864000),"some/path3");

		List<PathComparatorExample> list = new ArrayList<PathComparatorExample>();
		list.add(p3);
		list.add(p2);
		list.add(p1);
		
		//Collections.sort(list, dateComparator);
		list.sort(dateComparator);
		list.forEach((k) -> System.out.println(k.path));

	}

}
