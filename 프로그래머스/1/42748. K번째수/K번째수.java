import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        
        for (int a=0;a<commands.length;a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            //부분배열 만들기
            int[] subArray = Arrays.copyOfRange(array,i-1,j);
            Arrays.sort(subArray);
            answer[index] = subArray[k-1];
            index++;
        }
        return answer;
    }
}