import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {

        //입차 정보를 담을 map
        HashMap<String, String> in = new HashMap<>();
        
        //차량별 주차 시간을 담을 map
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str:records) {
            String[] temp = str.split(" ");
            String time = temp[0];
            String car = temp[1];
            String status = temp[2];
            
            //입차인 경우 입차 map에 담기
            if(status.equals("IN")) {
                in.put(car, time);
            }
            //출차인 경우 시간 계산 + 입차 map에서 삭제
            else {
                String[] temp_out = time.split(":");
                int out_time = Integer.parseInt(temp_out[0])*60 + Integer.parseInt(temp_out[1]);
                
                String[] temp_in = in.get(car).split(":");
                int in_time = Integer.parseInt(temp_in[0])*60 + Integer.parseInt(temp_in[1]);
                
                map.put(car, map.getOrDefault(car,0)+(out_time-in_time));
                
                //입차 map에서 삭제
                in.remove(car);
            }
        }
        
        //마지막까지 출차하지 않은 차 계산
        for(String s:in.keySet()) {
            String[] temp_in = in.get(s).split(":");
            int in_time = Integer.parseInt(temp_in[0])*60 + Integer.parseInt(temp_in[1]);
            map.put(s, map.getOrDefault(s,0)+(1439-in_time));
        }
        
        //오름차순 정렬
        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        int idx = 0;
        //요금 계산
        for(String s:list) {
            //기본시간 보다 작다면
            if(map.get(s) <= fees[0]) {
                answer[idx] = fees[1];
            }
            else {
                answer[idx] = (int)((Math.ceil((double)(map.get(s) - fees[0]) / fees[2])) * fees[3]) + fees[1];
            }
            idx++;
        }
        
        return answer;
    }
}