import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<10; i++) {
            s = s.replaceAll(word[i], Integer.toString(i));
        }
        
        return Integer.parseInt(s);
    }
}