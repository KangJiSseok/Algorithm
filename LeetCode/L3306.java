public class L3306 {
	public long countOfSubstrings(String word, int k) {

		int[] frontCon = new int[200001];
		int[] vowelArr = new int[5];
		int len = word.length();
		frontCon[len] = len;

		for(int i = len - 1; i >= 0; i--){
			if(vowel(word.charAt(i))){
				frontCon[i] = frontCon[i + 1];
			}else{
				frontCon[i] = i;
			}
		}

		int r = -1;
		int kCnt = 0;
		long result = 0;
		for(int l=0; l < len; l++){

			while((kCnt < k || !isVowel(vowelArr)) && r + 1 < len){
				r++;
				char c = word.charAt(r);
				if(vowel(c)){
					vowelAddArray(c,vowelArr);
				}else{
					kCnt++;
				}
			}

			if(isVowel(vowelArr) && kCnt == k){
				result += frontCon[r + 1] - r;
			}

			char c = word.charAt(l);
			if(vowel(c)){
				vowelRemoveArray(c,vowelArr);
			}else{
				kCnt--;
			}
		}
		return result;
	}

	private boolean vowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	private void vowelAddArray(char c, int[] vowelArr){
		if(c == 'a') vowelArr[0]++;
		else if(c == 'e') vowelArr[1]++;
		else if(c == 'i') vowelArr[2]++;
		else if(c == 'o') vowelArr[3]++;
		else if(c == 'u') vowelArr[4]++;
	}

	private void vowelRemoveArray(char c, int[] vowelArr){
		if(c == 'a') vowelArr[0]--;
		else if(c == 'e') vowelArr[1]--;
		else if(c == 'i') vowelArr[2]--;
		else if(c == 'o') vowelArr[3]--;
		else if(c == 'u') vowelArr[4]--;
	}

	private boolean isVowel(int[] vowelArr){
		for(int value : vowelArr){
			if(value <= 0) return false;
		}
		return true;
	}
}
