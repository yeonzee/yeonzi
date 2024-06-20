import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num:scoville) {
            heap.add(num);
        }
       
        int count = 0;
        while(true) {
            if(heap.peek()<K) {
                int current_1 = heap.poll();
                int current_2 = heap.poll();
                int a = current_1 + (current_2 *2);
                heap.add(a);
                count++;
            }
            else {
                break;
            }
            
            if(heap.size()==1 && heap.peek() < K) {
                return -1;
            }
        }
        
        return count;
    }
}