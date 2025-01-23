/*
차량의 입차 정보를 저장할 map, 출차시 이용한 시간을 저장할 map
이용 시간 map에서 차량번호로 오름차순
요금계산 -> 올림해야함!
*/
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        //차량 입/출차 정보 저장할 map
        HashMap<String, Integer> map = new HashMap<>();
        
        //차량들이 입/출차한 시간 및 요금 기록할 map
        HashMap<String, Integer> result = new HashMap<>();
    
        for(String str:records) {
            String[] temp = str.split(" ");
            String t = temp[0];
            String number = temp[1];
            String state = temp[2];
            
            String[] time_cal = t.split(":");
            int time = Integer.parseInt(time_cal[0])*60 + Integer.parseInt(time_cal[1]);
            
            //입차인 경우
            if(state.equals("IN")) {
                map.put(number, time);
            }
            //출차인 경우
            else {
                int total_t = time - map.get(number);
                result.put(number, result.getOrDefault(number, 0) + total_t);
                
                //출차했으므로 map에서 지워주기
                map.remove(number);
            }
        }
        
        //입차만 하고 출차x
        //23:59을 출차시간으로 계산 -> 1439
        for(String s:map.keySet()) {
            result.put(s, result.getOrDefault(s,0) + (1439-map.get(s)));
        }
        
        // 차량 번호 정렬을 위한 리스트 생성
        List<String> carList = new ArrayList<>(result.keySet());
        Collections.sort(carList); // 차량 번호 기준 오름차순 정렬

        int[] answer = new int[carList.size()];
        
        int index=0;
        //요금 계산
        for(String car:carList) {
            //기본요금
            if(result.get(car) <= fees[0]) {
                answer[index] = fees[1];
            }
            else {
                answer[index] = fees[1] + (int) Math.ceil((double) (result.get(car) - fees[0]) / fees[2]) * fees[3];
            }
            index++;
        }
        
        return answer;
    }
}