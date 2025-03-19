public class L3191 {
	public int minOperations(int[] nums) {

		int result = 0;
		for(int i=0; i< nums.length - 2; i++){

			if(!isAllOne(nums,i)){
				result++;
			}
		}

		if(nums[nums.length-2] == 1 && nums[nums.length-1] == 1) return result;
		return -1;
	}

	public boolean isAllOne(int[] nums, int i){
		if(nums[i] == 0){
			nums[i] ^= 1;
			nums[i + 1] ^= 1;
			nums[i + 2] ^= 1;
			return false;
		}
		return true;
	}
}
