class Solution {
    public int[] solution(String s) {
        
        int count =0;
        int result =0;
        while(s.length() != 1){
            
            while(s.contains("0")){
                s = s.replaceFirst("0","");
                count++;
            }
            
            s= Integer.toBinaryString(s.length());
            result ++;
        }
        
        int[] answer = new int[]{result,count};
        return answer;
    }
}