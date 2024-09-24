//어렵다 답보고 다시 풀음
//ex) stages[i] = 2일 경우
//0단계, 1단계 통과하여 2단계를 갔지만 2단계에서 실패한 것이다
//clear의 0과 1을 늘려주고, current에서는 1단계를 늘려준다(2단계에서 실패했기 때문에 내가 현재까지 깬 스테이지는 1이다)
//실패율은 분수이기 때문에 double형을 사용해준다

import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        //스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수
        int[] current_stage = new int[N+1];
        
        //스테이지에 도달한 플레이어 수
        int[] clear_stage = new int[N+1];
        
        for(int i=0; i<stages.length; i++) {
            for(int j=0; j<stages[i]; j++) {
                clear_stage[j]++;
            }
            current_stage[stages[i]-1]++;
        }
        
        //실패율을 담을 map
        HashMap<Integer, Double> map = new HashMap<>();
        
        //i+1을 하는 이유: 위에서 인덱스 0부터 넣어줬기 때문에  걍 숫자 대입해보면 알게 되더라
        for(int i=0; i<N; i++) {
            if(current_stage[i] == 0 || clear_stage[i] == 0) {
                map.put(i+1, 0.0);
            }
            else {
                double fail = (double)current_stage[i] / (double)clear_stage[i];
                map.put(i+1, fail);
            }
        }
        
        //map의 key값을 담은 list
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        
        //value값을 기준으로 내림차순 정렬
        //실패율이 double형이기 때문에 Double.compare 방식으로 정렬
        Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        //배열로 변환
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}