package com.xumh;

public class MatrixSearch {
	public boolean search(int[][] matrix,int target){
		int rows=matrix.length;
		if(rows==0){
			return false;
		}
		int columns=matrix[0].length;
		int row=0,column=columns-1;
		while(row<rows&&column>=0){
			if(matrix[row][column]==target){
				return true;
			}else if(matrix[row][column]>target){
				column--;
			}else{
				row++;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] A=new int[][]{{1,2},{3,4}};
		MatrixSearch ms=new MatrixSearch();
		System.out.println(ms.search(A, 5));
	}
}
