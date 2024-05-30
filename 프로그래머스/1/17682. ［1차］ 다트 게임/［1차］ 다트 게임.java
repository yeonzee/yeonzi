import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] result = new int[3];
        int index = -1;
        
        for(int i=0;i<dartResult.length();i++) {
            char c = dartResult.charAt(i);
            
            if (Character.isDigit(c)) {
                if (c == '1' && dartResult.charAt(i+1) == '0') {
                    result[++index] = 10;
                    i++; //0을 건너뛴다...!!!!
                }
                else {
                    result[++index] = c - '0';
                }
            }
                
            else if (c == 'S') {
                result[index] = (int)Math.pow(result[index],1);
            }
            else if (c == 'D') {
                result[index] = (int)Math.pow(result[index],2);
            }
            else if (c == 'T') {
                result[index] = (int)Math.pow(result[index],3);
            }

            else if (c == '*') {
                if (index > 0) { //이전 턴 존재
                    result[index-1] *= 2;
                }
                result[index] *= 2;
            }

            else if (c == '#') {
                result[index] *= -1;
            }  
        }
        
        for (int num:result) {
            answer += num;
        }
        return answer;
    }
}