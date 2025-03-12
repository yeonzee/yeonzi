import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        //약수의 갯수를 담을 배열
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=number; i++) {
            int count = 0;
            for(int j=1; j*j<=i; j++) {
                if(i % j == 0) {
                    count += 2;
                    
                    //제곱수일경우 -1
                    if(j*j == i) {
                        count -= 1;
                    }
                }
            }
            
            //제한 수치를 넘으면 power로 변경
            if(count > limit) {
                list.add(power);
            }
            else {
                list.add(count);
            }
        }
        
        for(int num:list) {
            answer += num;
        }
        
        return answer;
    }
}