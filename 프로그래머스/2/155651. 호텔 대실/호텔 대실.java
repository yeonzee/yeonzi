import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] time = new int[book_time.length][2];
        int idx = 0;
        
        //시간을 분 단위로 변환
        for(String[] t:book_time) {
            String[] temp1 = t[0].split(":");
            String[] temp2 = t[1].split(":");
            
            time[idx][0] = Integer.parseInt(temp1[0])*60 + Integer.parseInt(temp1[1]);
            time[idx][1] = Integer.parseInt(temp2[0])*60 + Integer.parseInt(temp2[1]) + 10;
            
            idx++;
        }
        
        //입실 시간순으로 오름차순 정렬
        Arrays.sort(time, (o1, o2) -> Integer.compare(o1[0],o2[0]));
        
        ArrayList<Integer> room = new ArrayList<>();
        
        for(int[] t:time) {
            //확인
            boolean check = false;
            
            for(int i=0; i<room.size(); i++) {
                //입실시간이 퇴실시간보다 크거나 같은 경우 해당 방 대실 가능
                if(room.get(i) <= t[0]) {
                    //i번 방에 퇴실 시간을 현재 예약의 퇴실 시간으로 수정
                    room.set(i, t[1]);
                    check = true;
                    break;
                }
            }
            
            //새로운 방이 필요한 경우
            if(!check) {
                room.add(t[1]);
            }
        }

        return room.size();
    }
        
      
}