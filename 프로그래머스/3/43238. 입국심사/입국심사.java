import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        //정렬
        Arrays.sort(times);
        
        long low = 1;
        long high = times[times.length-1] * (long)n;

        while(low <= high) {
            long mid = (low+high) / 2;
            
            long sum = 0;
            for(int i=0; i<times.length; i++) {
                sum += (mid / times[i]);
            }
            
            if(sum < n) {  //sum이 n보다 작다는 것은 시간이 더 필요하다는 뜻
                low = mid+1;
            }
            else {  //sum이 n보다 크거나 같다는 것은 시간을 더 줄여야 한다는 뜻
                high = mid-1;
                answer = mid;
            }
            
            
        }

        return answer;
    }
}