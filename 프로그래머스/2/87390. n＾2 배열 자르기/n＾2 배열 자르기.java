import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right-left) + 1;
        
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++) {
            //인덱스
            long index = i+left;
            //몫
            int a = (int)(index/n);
            //나머지
            int b = (int)(index%n);
            
            //둘 중에 큰 수에 +1
            answer[i] = Math.max(a,b)+1;
        }
        
        return answer;
    }
}

/*
index 0 → (0,0) → max(0,0)+1 = 1
index 1 → (0,1) → max(0,1)+1 = 2
index 2 → (0,2) → max(0,2)+1 = 3

index 3 → (1,0) → max(1,0)+1 = 2
index 4 → (1,1) → max(1,1)+1 = 2
index 5 → (1,2) → max(1,2)+1 = 3

index 6 → (2,0) → max(2,0)+1 = 3
index 7 → (2,1) → max(2,1)+1 = 3
index 8 → (2,2) → max(2,2)+1 = 3
*/