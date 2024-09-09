import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        //통과된 단어를 넣을 리스트
        ArrayList<String> arr = new ArrayList<>();
        arr.add(words[0]);  //첫번째 단어 넣어주기
        
        for(int i=1; i<words.length; i++) {
            //arr에 없고 앞에 단어와 연결된다면 arr에 단어 추가
            if(!arr.contains(words[i]) && words[i-1].charAt(words[i-1].length()-1) == words[i].charAt(0)) {
                arr.add(words[i]);
            }
            else {  //실패
                if((i+1) % n == 0) {
                    answer[0] = n;
                    answer[1] = (i+1) / n;
                }
                else {
                    answer[0] = (i+1) % n;
                    answer[1] = ((i+1) / n) + 1;
                }
                break;
            }
        }

        return answer;
    }
}