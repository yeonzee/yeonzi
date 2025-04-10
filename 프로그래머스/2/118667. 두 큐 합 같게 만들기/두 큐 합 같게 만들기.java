import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        //큐로 만들기
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        //합 구하기
        long sum1 = 0;
        long sum2 = 0;

        for(int i=0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        long sum = sum1+sum2;
        
        while(true) {
            //원소의 합이 같다면
            if(sum1 == (sum/2) && sum2 == (sum/2)) {
                break;
            }
            
            //q1이 작다면 q2에서 넘기기
            if(sum1 < sum/2) {
                q1.add(q2.peek());
                sum1 += q2.peek();
                sum2 -= q2.peek();
                q2.poll();
                answer++;
            }
            //q2가 작다면 q1에서 넘기기
            else if(sum2 < sum/2) {
                q2.add(q1.peek());
                sum2 += q1.peek();
                sum1 -= q1.peek();
                q1.poll();
                answer++;
            }
            
            //각 큐의 합이 같아질 수 없으면 -1
            //모든 원소가 제자리로 돌아오는 경우 -> queue1.length*4
            if(answer >= queue1.length*4) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}