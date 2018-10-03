package com.ds.examples;

public class NQueens {
	
	public static boolean IsDiagonalsValid(int[] [] grid,int row,int col) {
		
		boolean flag=false;
		
		// row increase col decrease , row decrease col increase
		// row increase col increase, row decrease col decrease

		 			// [2][1] --> [3][0] , [1][2] [0][3] 
			 //            [1][0],[3][2] 
/*			for(int i=1;i<4;i++) {
				int rowl = row+i; int coll=col-i;
				if(rowl < grid.length && coll>-1 && rowl>-1 && coll < grid.length) {
				if((grid[rowl][coll] == 0))
					flag = true;
				}
			}*/
		
			for(int i=1;i<4;i++) {
				int rowl = row-i; int coll=col+i;
				if(rowl < grid.length && rowl>-1 && coll>-1 && coll < grid.length) {
				if((grid[rowl][coll] != 0))
					return true;
				}
			}
		
		return false;
	}
	
	public static void iterateGrid(int[] [] grid) {
		for(int i=0;i< grid.length;i++) {
			for(int j=0;j< grid.length;j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		int[][] grid = new int[4][4];
		for(int i=0;i< grid.length;i++) {
			for(int j=0;j< grid.length;j++) {
				grid[i][j] = 0;
			}
		}
		grid[3][0] = 2;
		grid[1][2] = 3;
		
		iterateGrid(grid);
		System.out.println("is valild: "+ IsDiagonalsValid(grid,2,1));
		
	}

}
