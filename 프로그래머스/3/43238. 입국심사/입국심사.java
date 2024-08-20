import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        //정렬
        Arrays.sort(times);
        
        long answer = 0;
        
        long left = 0;
        long right = times[times.length-1] * (long)n;  //가장 큰 값
        
        while(left <= right) {
            long mid = (left+right) / 2;
            long sum = 0;  //입국심사 할 수 있는 사람 수
            
            for(int i=0; i<times.length; i++) {
                sum += mid / times[i];
            }
            
            if(sum < n) {  //시간이 더 필요하다
                left = mid+1;
            }
            else {
                right = mid-1;
                answer = mid;
            }
        }
        return answer;
    }
}