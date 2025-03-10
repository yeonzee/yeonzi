//효율성을 위해 이분탐색
import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 0;
        int right = 200000000;
        
        //left랑 right가 같아지면 끝
        while(left < right) {
            int mid = (left+right)/2;
            //건널 수 있다면
            if(check(mid, k, stones)) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        
        return left;
    }
    
    public boolean check(int mid, int k, int[] stones) {
        
        //못건너는 돌다리 갯수
        int cnt = 0;
        
        //최대 못건너는 돌다리 갯수
        int max = 0;
        
        for(int n:stones) {
            //돌다리 하나에 건널 수 있는 사람의 수
            //이게 음수나 0이면 mid명만큼 건널 수 없는 돌이라는 뜻
            int temp = n-mid;
            
            //건널 수 없을 때
            if(temp <= 0) {
                cnt++;
            }
            else {
                max = Math.max(max, cnt);
                //연속으로 못건너는 돌다리를 구하는 것이기 때문에 cnt 초기화
                cnt = 0;
            }
        }
        
        //마지막까지 0이 지속되는 경우를 위해 max값을 한번 더 구함
        max = Math.max(max, cnt);
        
        //k보다 작으면 건널 수 있으므로 true 반환
        if(max<k) {
            return true;
        }
        
        return false;
    }
}


/*
rigth = mid를 쓰는 이유

- right = mid - 1을 쓰는 경우
보통 정확한 값을 찾는 경우에 사용
예: 특정 숫자를 찾는 이진 탐색 (target이 있으면 mid를 반환)

- right = mid를 쓰는 경우
보통 최댓값 또는 최솟값을 찾는 경우에 사용
예: 조건을 만족하는 최대/최소 값을 찾는 문제
*/