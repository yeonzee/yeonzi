import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        //이전의 값을 담을 리스트
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
        
        for(int i=1; i<words.length; i++) {
            
            //규칙에 어긋나는지 확인
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }
            
            //이전에 등장한 단어인지 확인
            if(list.contains(words[i])) {
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }
            
            list.add(words[i]);
        }
        
        return answer;
    }
}