package com.normal.samples;

public class SomeImpl {
	
	private DataService dataService;
	
	public SomeImpl(DataService dataService) {
		this.dataService = dataService;
	}

	public Integer getGreatest() {
		Integer greatest = Integer.MIN_VALUE;
		Integer[] allValues = dataService.retrieveAll();
		for (int i = 0; i < allValues.length; i++) {
			if(allValues[i] > greatest)
				greatest = allValues[i];
		}
		return greatest;
	}
}
