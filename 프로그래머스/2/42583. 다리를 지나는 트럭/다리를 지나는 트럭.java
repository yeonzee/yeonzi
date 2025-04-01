//queue 사용
import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        //대기하고있는 트럭
        Queue<Integer> wait_q = new LinkedList<>();
        //다리 위에 있는 트럭
        Queue<Integer> now_q = new LinkedList<>();
        //다리 위에 있는 트럭 시간
        Queue<Integer> time_q = new LinkedList<>();
        
        //전체 시간
        int minute = 0;
        //처리한 트럭 갯수
        int total_count = 0;
        //현재 다리 위에 있는 트럭 갯수
        int bridge_truck_count = 0;
        //다리 무게
        int bridge_weight = 0;
        
        //처음 들어온 트럭 대기 큐에 넣기
        for(int t:truck_weights) {
            wait_q.add(t);
        }
        
        //처리한 트럭 갯수와 처음 들어온 트럭 갯수가 일치할 때까지 반복
        while(total_count != truck_weights.length) {
            minute++;       //총 시간
            
            //트럭 내리기
            //도로가 꽉찼다면 = 해당 트럭이 도로위에 있을 시간이 다 되었다면
            if(!time_q.isEmpty() && time_q.peek() == bridge_length) {
                bridge_weight -= now_q.peek();      //현재 다리 무게에서 내린 트럭 무게 빼기
                bridge_truck_count--;       //현재 다리위의 트럭 갯수에서 하나 빼기
                time_q.poll();      //해당 트럭의 시간 삭제
                now_q.poll();       //현재 다리 위의 트럭 삭제
                total_count++;
                
            }
            
            //트럭 올리기
            //대기하고 있는 트럭이 있다면
            if(!wait_q.isEmpty()) {
                int truck = wait_q.peek();
                
                //현재 도로에 있는 트럭들의 무게와 들어오는 트럭의 무게가 weight보다 작고
                //트럭의 갯수가 다리 길이보다 작다면 트럭을 더 올려도 됨.
                if(bridge_weight+truck <= weight && bridge_truck_count <= bridge_length) {
                    now_q.add(truck);      //다리에 트럭 추가
                    bridge_weight += truck;     //다리 무게에 트럭 무게 추가
                    bridge_truck_count++;       //다리에 있는 트럭 갯수 추가
                    time_q.add(0);      //시간큐에 0 넣기
                    wait_q.poll();      //다리 위에 올렸으므로 대기 큐에서 삭제
                }
            }
            
            //다리 위에 머문 시간 증가
            for(int i=0; i<time_q.size(); i++) {
                time_q.add(time_q.poll()+1);
            }
        }
        
        return minute;
    }
}