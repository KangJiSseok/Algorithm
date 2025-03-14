class L1358 {
	public int numberOfSubstrings(String s) {
		int[] alpha = new int[3];
		int l = 0;
		int r = 0;
		int len =  s.length();
		int result = 0;
		while(r < len){
			alpha[s.charAt(r++) - 'a']++;
			while(isABC(alpha) && l < r){
				result++;
				result += len - r ;
				alpha[s.charAt(l++) - 'a']--;
			}

		}

		return result;

	}

	public boolean isABC(int[] alpha){
		if(alpha[0] > 0 && alpha[1] > 0 && alpha[2] > 0) return true;
		return false;
	}

}
