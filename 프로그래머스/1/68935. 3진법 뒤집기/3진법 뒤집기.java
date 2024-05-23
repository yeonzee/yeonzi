import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> a = new ArrayList<>();
        
        while(n>0) {
            a.add(n % 3);
            n /= 3;
        }
        
        for (int i = 0;i<a.size();i++) {
            answer += a.get(a.size()-1-i) * Math.pow(3,i);
            
        }
        return answer;
    }
}