//for문 하나를 돌려 map에 저장해두었다가 for문으로 다시 꺼내 list에 담기
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        
        //후에 들어오는 enter와 change의 name 값이 들어감
        for(String str:record) {
            String[] part = str.split(" ");
            
            String state = part[0];
            String id = part[1];
            //state가 leave일 경우 part[2]가 없기 때문에 오류 발생
            
            if(state.equals("Enter") || state.equals("Change")) {
                String name = part[2];
                map.put(id, name);
            }
        }
        
        for(String str:record) {
            String[] part = str.split(" ");
            
            String state = part[0];
            String id = part[1];
            
            if(state.equals("Enter")) {
                list.add(map.get(id) + "님이 들어왔습니다.");
            }
            else if(state.equals("Leave")) {
                list.add(map.get(id) + "님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[list.size()];
        
        return list.toArray(answer);
    }
}