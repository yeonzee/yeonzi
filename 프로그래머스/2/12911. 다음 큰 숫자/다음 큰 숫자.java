import java.util.*;
class Solution {
    public int solution(int n) {
        
        //1의 갯수
        int len = Integer.bitCount(n);
        
        while(true) {
            n++;
            
            //1의 갯수
            int len_n = Integer.bitCount(n);
            
            //종료조건
            if(len==len_n) {
                break;
            }
        }

        return n;
    }
}
//Integer.bitCount()