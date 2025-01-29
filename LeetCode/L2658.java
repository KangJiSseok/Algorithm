public class L2658 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};

	public int findMaxFish(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int max = 0;

		boolean[][] visited = new boolean[row][col];

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(!visited[i][j] && grid[i][j] > 0){
					max = Math.max(max, dfs(grid, i, j, row, col, visited));
				}
			}
		}
		return max;
	}

	public int dfs(int[][] grid, int y, int x, int row, int col, boolean[][] visited){
		visited[y][x] = true;
		int sum = grid[y][x];

		for(int i = 0; i < 4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(0<=ny && ny< row && 0<=nx && nx < col && !visited[ny][nx] && grid[ny][nx] > 0){
				sum += dfs(grid, ny, nx, row, col, visited);
			}
		}

		return sum;
	}
}
