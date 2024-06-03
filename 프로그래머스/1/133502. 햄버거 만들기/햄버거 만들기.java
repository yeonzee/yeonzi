/*
리스트에 ingredient를 하나씩 넣은 후 4개가 됐을 때부터 역순으로 조사
1321이 있으면 +1, 리스트에서 제거
*/

import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> li = new ArrayList<>();
        int count = 0;
        for (int a:ingredient) {
            li.add(a);
            if (li.size()>=4 
                 && li.get(li.size()-1)==1 
                 && li.get(li.size()-2)==3
                 && li.get(li.size()-3)==2
                 && li.get(li.size()-4)==1) {
                count++;

                for (int j=0;j<4;j++) {
                    li.remove(li.size()-1);
                }
            }
        }
        return count;
    }
}