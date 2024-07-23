//복습_하지만 푸는 방법을 몰라 답을 봤음
//투포인터 풀이 방식
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        //정렬
        Arrays.sort(people);
        
        //처음부터(제일 작은 숫자)
        int i=0;
        //마지막부터(제일 큰 숫자)
        int j = people.length-1;
        
        while(i<=j) {
            //제일 적은 몸무게와 제일 큰 몸무게를 더했을 때 한계치를 초과한다면 제일 큰 몸무게만 빼준다
            if(people[i]+people[j]>limit) {
                j--;
            }
            //더했을 때 한계치보다 작다면
            else {
                //제일 적은 몸무게와 제일 큰 몸무게 삭제
                i++;
                j--;
            }
            answer++;
        }
        return answer;
    }
}