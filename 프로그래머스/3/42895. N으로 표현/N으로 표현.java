import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        ArrayList<Set<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<9; i++) {
            list.add(new HashSet<>());
        }
        
        //1개 일때는 N만 들어감
        list.get(1).add(N);
        
        if(N == number) {
            return 1;
        }
        
        for(int i=2; i<9; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i; j++) {
                sb.append(N);
            }
            
            list.get(i).add(Integer.parseInt(sb.toString()));
            
            //사칙연산
            for(int j=1; j<i; j++) {
                int k = i-j;
                for(int num1:list.get(j)) {
                    for(int num2:list.get(k)) {
                        list.get(i).add(num1+num2);
                        list.get(i).add(num1-num2);
                        list.get(i).add(num1*num2);
                        
                        //0으로 나누면 오류
                        if(num2 != 0) {
                            list.get(i).add(num1/num2);
                        }
                        
                    }
                }
            }
            if(list.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}