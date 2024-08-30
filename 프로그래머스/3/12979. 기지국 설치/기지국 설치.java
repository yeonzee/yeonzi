//for문 여러개 돌리려고 했는데 n이 2억이다 포기
//1.구간별로 나눈다
//2.w*2+1 -> 전파 전달 범위
import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int leftStart = 1;
        
        Arrays.sort(stations);

        for (int sub : stations) {
            if (leftStart < sub - w) {
                int leftEnd = sub - w;

                int length = leftEnd - leftStart;

                int count = length / (w * 2 + 1);
                if (length % (w * 2 + 1) != 0)  //딱 나누어 떨어지지 않으면 추가 기지국이 필요하다는 뜻
                    count++;

                answer += count;
            }

            leftStart = sub + w + 1;
        }

        if(stations[stations.length-1] + w + 1 <= n){
            leftStart = stations[stations.length-1] + w + 1;

            int leftEnd = n + 1;

            int length = leftEnd - leftStart;

            int count = length / (w * 2 + 1);
            if (length % (w * 2 + 1) != 0)
                count++;

            answer += count;
        }

        return answer;
    }
}