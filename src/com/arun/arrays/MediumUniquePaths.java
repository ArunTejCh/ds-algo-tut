package com.arun.arrays;

public class MediumUniquePaths {

	public static void main(String[] args) {
		MediumUniquePaths inst = new MediumUniquePaths();

		int res1 = inst.uniquePaths(1, 2);
		assert res1 == 1;

		int res2 = inst.uniquePaths(23, 12);
		assert res1 == 1;
	}

	public int uniquePaths(int m, int n) {
		// return recurse(0,0,m-1,n-1,0);
		int[][] paths = new int[m][n];
		this.recurse(0, 0, m - 1, n - 1, paths);
		return paths[0][0];
	}

	/*
	 * public int recurse(int x, int y, int m, int n, int count) {
	 * 
	 * // base case for recursion if (x == m && y == n) { return ++count; }
	 * 
	 * if (x != m) count = recurse(x + 1, y, m, n, count);
	 * 
	 * if (y != n) count = recurse(x, y + 1, m, n, count);
	 * 
	 * return count; }
	 */

	public void recurse(int x, int y, int m, int n, int[][] paths) {
		if (x == m && y == n) {
			paths[x][y] = 1;
			return;
		}
		
		int downPaths = 0;
		int rightPaths = 0;
		
		if(x != m){
			if(paths[x+1][y] != 0){
				rightPaths = paths[x+1][y];
			}else{
				recurse(x+1, y, m, n, paths);
				rightPaths = paths[x+1][y];
			}
		}
		
		if(y != n){
			if(paths[x][y+1] != 0){
				downPaths = paths[x][y+1];
			}else{
				recurse(x, y+1, m, n, paths);
				downPaths = paths[x][y+1];
			}
		}
		
		paths[x][y] = rightPaths + downPaths;
			
	}

}
