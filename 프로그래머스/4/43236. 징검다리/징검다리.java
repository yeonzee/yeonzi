//뭔데 이거
import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        //정렬
        Arrays.sort(rocks);
        int answer = 0;
        
        //돌 간격 저장할 배열
        int[] sub = new int[rocks.length + 1];
        
        sub[0] = rocks[0];  //처음 위치(0)에서 첫번째 돌 까지 간격
        sub[rocks.length] = distance - rocks[rocks.length - 1];  //최종거리에서 마지막 돌 까지 간격
        
        //돌 간격
        for (int i = 1; i < rocks.length; i++) {
            sub[i] = rocks[i] - rocks[i - 1];
        }
        
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;  //돌 간격 합
            int cnt = 0;  //제거한 돌 갯수
            
            for (int i = 0; i < sub.length; i++) {
                sum += sub[i];  
                if (sum < mid) {
                    cnt++;  // 바위를 제거
                } else {
                    sum = 0;  // sum을 초기화하여 새로운 구간 시작
                }
            }
            
            // 전체 루프가 끝난 후 cnt 검사
            if (cnt > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        return answer;
    }
}
