package com.arun.arrays;

public class MediumUniquePathsII {

	public static void main(String[] args) {
		
		MediumUniquePathsII inst = new MediumUniquePathsII();
		
		int[][] arg1 = {{0}};
		int res1 = inst.uniquePathsWithObstacles(arg1);
		assert res1 == 1;
		
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] paths = new int[m][n];
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				paths[i][j] = -1;
			}
		}
		this.recurse(0, 0, m - 1, n - 1, paths, obstacleGrid);
		return paths[0][0];
	}
	
	public void recurse(int x, int y, int m, int n, int[][] paths, int[][] obstacleGrid) {
		
		if(obstacleGrid[x][y] == 1){
			paths[x][y] = 0;
			return;
		}
		
		
		if (x == m && y == n) {
			paths[x][y] = 1;
			return;
		}
		
		int downPaths = 0;
		int rightPaths = 0;
		
		if(x != m){
			if(paths[x+1][y] != -1){
				rightPaths = paths[x+1][y];
			}else{
				recurse(x+1, y, m, n, paths, obstacleGrid);
				rightPaths = paths[x+1][y];
			}
		}
		
		if(y != n){
			if(paths[x][y+1] != -1){
				downPaths = paths[x][y+1];
			}else{
				recurse(x, y+1, m, n, paths, obstacleGrid);
				downPaths = paths[x][y+1];
			}
		}
		
		paths[x][y] = rightPaths + downPaths;
			
	}
}
