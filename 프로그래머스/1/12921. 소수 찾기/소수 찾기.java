//에라토스테네스의 체
import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        //true->소수 false->소수아님
        //new boolean형 배열 생성
        //숫자와 인덱스를 맞추기 위해 n+1사용
        boolean[] isprime = new boolean[n+1];
        Arrays.fill(isprime, true);
        //0과 1은 소수가 아니므로 false
        isprime[0] = false;
        isprime[1] = false;
        
        for (int i=2;i*i<=n;i++) {
            //i가 소수라면
            if(isprime[i]) {
                //i의 배수는 약수가 될 수 없으므로 false
                for(int j=i*i;j<=n;j+=i) {
                    isprime[j] = false;
                }
            }
        }
        //배열에 true(소수) 개수 구하기
        int count = 0;
        for (int k=0;k<=n;k++) {
            if(isprime[k]){
                count++;
            }
        }
        
        return count;
    }
}