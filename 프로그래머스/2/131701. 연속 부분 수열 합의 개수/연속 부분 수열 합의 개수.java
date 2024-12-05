import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        //중복 방지를 위한 set
        HashSet<Integer> set = new HashSet<>();
        
        //길이=i
        for(int i=1; i<=elements.length; i++) {
            //인덱스
            for(int j=0; j<elements.length; j++) {
                int sum=0;  //초기화
                for(int k=j; k<j+i; k++) {
                    sum += elements[k%elements.length];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}