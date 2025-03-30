public class 옹알이2 {
	public int solution(String[] babbling) {
		String[] arr1 = {"aya","ye","woo","ma"};
		String[] arr2 = {"ayaaya","yeye","woowoo","mama"};

		int result = 0;
		for(int i=0; i< babbling.length; i++){
			String tar = babbling[i];
			boolean a = false;
			for (int j = 0; j < 4; j++) {
				if(tar.contains(arr2[j])) {
					a = true;
					break;
				}
			}
			if (a) continue;

			for (int j = 0; j < 4; j++) {
				tar = tar.replace(arr1[j], " ");
			}

			tar = tar.replace(" ","");
			if(tar.length() == 0) result++;
		}
		return result;
	}
}
