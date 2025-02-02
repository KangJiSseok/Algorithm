public class L1752 {
	public boolean check(int[] nums) {
		int count = 0;
		int size = nums.length;
		for(int i=0; i< size; i++){
			if(nums[i] <= nums[(i+1) % size]){
				continue;
			}else{
				count++;
			}
		}

		if(count >= 2){
			return false;
		}else{
			return true;
		}
	}
}
