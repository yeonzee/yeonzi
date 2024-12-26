// 배열의 길이가 짧은 순대로 배열 한 후 순서대로 숫자 집어넣기
import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        //String을 배열로 변환
        //},{를 replace 하는 이유: 정규표현식에서 반복 횟수를 정하는 기호이기 때문에
        String str = s.substring(2,s.length()-2).replace("},{","-");
        String[] arr = str.split("-");
        
        //길이순으로 배열
        Arrays.sort(arr,(o1,o2)->o1.length()-o2.length());
        
        
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i].length() == 1) {
                list.add(arr[i]);
            }
            else {
                String[] temp = arr[i].split(",");
                
                for(int j=0; j<temp.length; j++) {
                    //list에 없다면 넣기
                    if(!list.contains(temp[j])) {
                        list.add(temp[j]);
                        break;
                    }
                }
            }
        }
        
        int[] answer = new int[arr.length];
        for(int i=0; i<list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }
        return answer;
    }
}