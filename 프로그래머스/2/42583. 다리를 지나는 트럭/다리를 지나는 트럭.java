import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        //기다리는 트럭
        Queue<Integer> waitQueue = new LinkedList<>();
        //도로위에 있는 트럭
        Queue<Integer> nowQueue = new LinkedList<>();
        //도로위에 있는 시간
        Queue<Integer> timeQueue = new LinkedList<>();
        
        //현재 트럭 대기큐에 넣기
        for (int truckWeight:truck_weights) {
            waitQueue.add(truckWeight);
        }
        
        //시간
        int minute = 0;
        //다리무게
        int bridgeweight = 0;
        //다리위에 올라가 있는 트럭 갯수
        int bridgeTruckCount = 0;
        //처리한 트럭 갯수
        int totalCount = 0;
        
        //처리한 트럭 갯수와 처음 들어온 트럭 갯수가 같을 때까지 반복
        while(totalCount != truck_weights.length) {
            minute++;
            
            //도로가 꽉찼다면
            if(timeQueue.peek() != null && timeQueue.peek() == bridge_length) {
                timeQueue.poll();
                bridgeweight -= nowQueue.poll();
                bridgeTruckCount--;
                totalCount++;
            }
            
            //기다리고 있는 트럭이 있다면
            if(waitQueue.peek() != null) {
                int truck = waitQueue.peek();
                //현재 도로에 있는 트럭들의 무게와 들어오는 트럭의 무게가 weight보다 작고, 트럭의 갯수가 다리 길이보다 작다면 도로위에 트럭을 더 올려도 됨
                if(truck + bridgeweight <= weight && bridgeTruckCount <= bridge_length) {
                    bridgeweight += truck;
                    bridgeTruckCount++;
                    //현재 도로에 트럭 값 넣어주기
                    nowQueue.add(waitQueue.poll());
                    //시간큐에 0 넣기
                    timeQueue.add(0);
                }
            }
            
            //시간큐에 가장 최근에 들어온 값에 1을 더해준다
            for (int i=0; i<timeQueue.size(); i++) {
                timeQueue.add(timeQueue.poll()+1);
            }
        }
        
        
        
        
        
        return minute;
    }
}