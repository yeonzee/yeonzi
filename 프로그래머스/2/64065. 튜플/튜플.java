//길이가 작은 순서대로 리스트에 넣기
import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        //s 나누기(정렬하기위한 배열로 만들기)
        String str = s.substring(2, s.length()-2).replace("},{", "-");
        String[] arr = str.split("-");
        
        //길이가 작은 순으로 정렬
        Arrays.sort(arr, (o1, o2) -> o1.length()-o2.length());
       
        ArrayList<String> list = new ArrayList<>();
        
        for(String t:arr) {
            String[] temp = t.split(",");
            
            for(int i=0; i<temp.length; i++) {
                if(list.contains(temp[i])) {  //이미 포함되어 있다면
                    continue;
                }
                else {
                    list.add(temp[i]);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int j=0; j<list.size(); j++) {
            answer[j] = Integer.parseInt(list.get(j));
        }
        
        return answer;
    }
}