//이분탐색인걸 눈치챌 수 있을련지...
import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        //정렬
        Arrays.sort(times);
        long answer = 0;
        long left = 0; //가장 작은 값
        long right = times[times.length-1] * (long)n; //가장 큰 값 ex)10*6
        
        while(left <= right) {
            long mid = (left+right) / 2;
            //입국심사 할 수 있는 사람 수
            long sum = 0;
            
            for(int i=0; i<times.length; i++) {
                sum += mid / times[i];
            }
            
            //n보다 작을 경우 시간이 더 필요함
            if(sum < n) {
                left = mid+1;
            }
            //n보다 크거나 같을 경우 더 최적의 값이 있을 수 있음
            else {
                right = mid-1;
                answer = mid;
            }
        }
        
        
        return answer;
    }
}