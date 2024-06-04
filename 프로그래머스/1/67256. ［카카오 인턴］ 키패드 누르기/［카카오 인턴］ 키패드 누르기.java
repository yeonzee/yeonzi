import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 12;
        for (int i=0; i<numbers.length;i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                left = numbers[i];
                sb.append("L");
                
            }
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                right = numbers[i];
                sb.append("R");
                
            }
            
            if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i]  == 0) {
                if (numbers[i] == 0) {
                    numbers[i] = 11;
                }
                int leftdiff = (Math.abs(numbers[i]-left) / 3) + (Math.abs(numbers[i]-left) % 3);
                int rightdiff = (Math.abs(numbers[i]-right) / 3) + (Math.abs(numbers[i]-right) % 3);
                
                if (leftdiff > rightdiff) {
                    right = numbers[i];
                    sb.append("R");
                    
                }
                else if (leftdiff < rightdiff) {
                    left = numbers[i];
                    sb.append("L");
                    
                }
                else if (leftdiff == rightdiff) {
                    if (hand.equals("right")) {
                        right = numbers[i];
                        sb.append("R");
                        
                    }
                    else {
                        left = numbers[i];
                        sb.append("L");
                        
                    }
                }
            }
        }
        return sb.toString();
    }
}