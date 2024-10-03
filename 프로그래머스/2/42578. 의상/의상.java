//해시맵 사용
//조합 예시
//A->a,b 2개
//B->c,d,e 3개
//C->f 1개
//2+1 = a,b 다 입는 경우 + 둘 다 안입는 경우
//3+1 = c,d,e 다 입는 경우 + 둘 다 안입는 경우
//1+1 = f 입는 경우 + 안입는 경우
//마지막에 -1 = 세 종류 다 안입는 경우

import java.util.*;
class Solution {
    public int solution(String[][] clotheas) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clotheas.length; i++) {
            map.put(clotheas[i][1], map.getOrDefault(clotheas[i][1],0)+1);
        }
        
        //조합
        for(String str:map.keySet()) {
            answer *= map.get(str)+1;
        }
        return answer-1;
    }
}