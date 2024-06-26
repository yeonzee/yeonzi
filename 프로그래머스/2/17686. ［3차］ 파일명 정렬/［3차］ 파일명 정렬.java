/*head, number, tail부분
대소문자 구분 없으니 다 lower해주기*/
import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        //head, number, tail을 저장할 배열
        String[][] answer_3 = new String[files.length][3];
        
        for(int j=0;j<files.length;j++) {
            String str = files[j];
            int start = 0;
            int num_len = 0;
            int end = 0;
            //number의 길이를 확인하기 위한 불린
            boolean check = true;
            
            for(int i=0;i<str.length();i++) {
                //숫자라면
                if(Character.isDigit(str.charAt(i))) {
                    if(check) {
                        start = i;
                        check = false;
                    }
                    num_len++;
                }
                else{
                    if(!check) {
                        break;
                    }
                }
            }
            end = start + num_len;
            //start는 number이 시작하는 부분, num_len은 number의 길이를 나타냄, end는 number이 끝나는 부분
            
            String head = str.substring(0,start);
            String number = str.substring(start,end);
            String tail = str.substring(end);
            
            answer_3[j][0] = head;
            answer_3[j][1] = number;
            answer_3[j][2] = tail;
        }
        //head의 문자열 순으로 정렬하고 만약 head가 같을 시 number순으로 정렬
        Arrays.sort(answer_3, (o1,o2) -> {
            if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase())>0) {
                return 1;
            }
            else if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase())<0) {
                return -1;
            }
            else {
                if(Integer.parseInt(o1[1])>Integer.parseInt(o2[1])) {
                    return 1;
                }
                else if(Integer.parseInt(o1[1])<Integer.parseInt(o2[1])) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        });
        
        //string이므로 +로 붙여넣기
        for(int i=0;i<files.length;i++) {
            answer[i] = answer_3[i][0] + answer_3[i][1] + answer_3[i][2];
        }
        return answer;
    }
}