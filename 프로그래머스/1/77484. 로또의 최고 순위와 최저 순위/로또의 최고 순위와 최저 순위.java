//최고 순위 -> 0을 다 맞는 숫자로 바꾸기
//최저 순위 -> 0을 다 안맞는 숫자로 바꾸기
import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        //정렬
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        //기존에 맞춘 번호 찾기
        int cnt = 0;
        for(int i=0; i<lottos.length; i++) {
            for(int j=0; j<win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) {
                    cnt++;
                    break;
                }
            }
        }
        
        answer[1] = 7-cnt;
        
        //1개 맞춰도, 하나도 못맞춰도 6등
        if(cnt == 0 || cnt == 1) {
            answer[1] = 6;
        }
        
        //0찾기
        for(int n:lottos) {
            if(n==0) {
                cnt++;
            }
        }
        
        answer[0] = 7-cnt;
        
        //1개 맞춰도, 하나도 못맞춰도 6등
        if(cnt == 0 || cnt == 1) {
            answer[0] = 6;
        }
        
        return answer;
    }
}