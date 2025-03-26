import java.util.Arrays;

class L2033 {
	public int minOperations(int[][] grid, int x) {

		int yLen = grid.length;
		int xLen = grid[0].length;
		int[] arr = new int[yLen*xLen];

		for(int i=0; i < yLen; i++){
			for(int j=0; j< xLen; j++){
				arr[(xLen * i) + j] = grid[i][j];
			}
		}

		Arrays.sort(arr);
		int mid = arr[arr.length/2];
		int result = 0;

		for(int i=0; i< arr.length; i++){
			int abs = Math.abs(arr[i] - mid);
			if(abs % x != 0) return -1;
			result += abs / x;
		}

		return result;
	}
}


