//N이 i개가 있는 통을 담을 list만들기 ex) N이 5일 때 5,55,555....
//i가 3일때 i가1인통 (+-/*) i가 2인통 하면 됨 ex) 555, 5-55, 5*55
//+,-같은 경우는 반대로 하면 값이 달라지므로 반대로도 해야 함 ex) 5-55, 55-5
//통을 만들다가 number와 같은 값이 있으면 i값 리턴
//i가 8을 넘어가면 -1 리턴
//개어렵다

import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        //값을 담을 list 만들기
        ArrayList<Set<Integer>> list = new ArrayList<>();
        
        //i의 갯수만큼 set 만들기
        //i를 0부터 시작한 이유는 인덱스는 0부터 시작하기 때문(i=1이라 하면 안됨)
        for(int i=0; i<9; i++) {
            list.add(new HashSet<>());
        }
        
        //i가 1일 경우는 N하나만 들어감
        list.get(1).add(N);
        
        //number이 N과 같다면 하나만 쓰인 것이므로 1을 반환
        if(N == number) {
            return 1;
        }
        
        for(int i=2; i<9; i++) {
            
            //5,55,555와 같은 숫자 넣기
            StringBuilder sb = new StringBuilder();
            for(int j=1; j<=i; j++) {
                sb.append(N);
            }
            list.get(i).add(Integer.parseInt(sb.toString()));
            
            //사칙연산 계산해서 통에 넣기
            for(int j=1; j<i; j++) {
                int k = i-j;
                for(int num1:list.get(j)) {
                    for(int num2:list.get(k)) {
                        list.get(i).add(num1+num2);
                        list.get(i).add(num1-num2);
                        list.get(i).add(num1*num2);
                        
                        //0으로 나누면 오류뜨기 때문에
                        if(num2 != 0) {
                            list.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            //지금 통에 number가 있다면 i의 값이 N의 최솟값임
            if(list.get(i).contains(number)) {
                return i;
            }
        }
        
        //아니면 -1 리턴
        return -1;
    }
}