class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int len = 0;
        int num = 0;
        
        while(true) {
            //종료조건
            if(s.equals("1")) {
                break;
            }
            int len_before = s.length();
            
            s = s.replaceAll("0","");
            
            int len_after = s.length();
            len += len_before - len_after;
            
            s = Integer.toBinaryString(len_after);

            num++;
        }
        
        answer[0] = num;
        answer[1] = len;
        
        return answer;
    }
}