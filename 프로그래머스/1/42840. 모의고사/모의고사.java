import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        //각 수포자들이 맞은 갯수 리스트
        int[] count = new int[3];
        
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] thr = {3,3,1,1,2,2,4,4,5,5};
        
        //나머지로 구하기@@@
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%one.length]) {
                count[0]++;
            }
            if(answers[i] == two[i%two.length]) {
                count[1]++;
            }
            if(answers[i] == thr[i%thr.length]) {
                count[2]++;
            }
        }
        
        //가장 큰 수 뽑기
        int max = 0;
        for(int num:count) {
            max = Math.max(max, num);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<count.length; i++) {
            int n = count[i];
            if(n==max) {
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        //리스트 배열로 만들기
        return answer;
    }
}