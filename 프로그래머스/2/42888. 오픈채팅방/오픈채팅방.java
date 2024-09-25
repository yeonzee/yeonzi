//enter leave change일 경우로 나누기
//map 사용
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        //아이디와 각 닉네임을 담을 map
        HashMap<String, String> map = new HashMap<>();
        
        //결과를 넣을 리스트
        ArrayList<String> list = new ArrayList<>();
        
        //순서대로 넣기 때문에 뒤에서 새로 갱신 된 닉네임이 들감
        for(int i=0; i<record.length; i++) {
            String[] temp = record[i].split(" ");
            
            String cmd = temp[0];
            String id = temp[1];
            
            //leave 에는 이름이 없으므로 제외
            if(!cmd.equals("Leave")) {
                map.put(id,temp[2]);
            }
        }
        
        //명령어에 따라 입력
        for(int i=0; i<record.length; i++) {
            String[] temp = record[i].split(" ");
            
            String cmd = temp[0];
            String id = temp[1];
            
            if(cmd.equals("Enter")) {
                list.add(map.get(id)+"님이 들어왔습니다.");
            }
            else if(cmd.equals("Leave")) {
                list.add(map.get(id)+"님이 나갔습니다.");
            }
        }
        
        String[] answer = new String[list.size()];
        
        //리스트를 배열로 변환
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}