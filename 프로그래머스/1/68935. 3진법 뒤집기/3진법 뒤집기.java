import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
    
        ArrayList<Integer> list = new ArrayList<>();
        
        while(n > 0) {
            int num = n%3;
            list.add(num);
            n/=3;
        }
        
        int len = list.size();
        for(int i=0; i<len; i++) {
            answer += Math.pow(3,i)*list.get(len-i-1);
        }
        
        return answer;
    }
}