public class L2401 {
	public int longestNiceSubarray(int[] nums) {

		int bit = 0;
		int max = 1;
		for(int l=0,r=0; r< nums.length; r++){

			while((bit & nums[r]) != 0){
				bit ^= nums[l++];
			}

			bit |= nums[r];
			max = Math.max(max,r - l + 1);
		}
		return max;
	}
}
