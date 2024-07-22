//틀린 이유: 여벌 체육복을 가져온 학생이 체육복을 도난당했을 경우 남은 체육복이 하나이기에 다른 학생에게 못빌려줌
//이걸 생각 못해서 틀림 젠장
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        boolean[] checkI = new boolean[lost.length];
        boolean[] checkJ = new boolean[reserve.length];
        
        int count = 0;
        
        //여벌 체육복이 있는 학생인데 도난당했을 경우 먼저 계산
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if((lost[i]==reserve[j]) && !checkJ[j] && !checkI[i]) {
                    checkI[i] = true;
                    checkJ[j] = true;
                    count++;
                }
            }
        }
        
        //나머지 계산
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                //앞뒤에서 빌려주기
                if((lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) && !checkJ[j] && !checkI[i]) {
                    checkI[i] = true;
                    checkJ[j] = true;
                    count++;
                }
            }
        }

        answer = n - (lost.length-count);
        return answer;
    }
}