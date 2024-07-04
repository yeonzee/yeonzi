//1.정렬
//2.S 구하기
//3.XOR 비트 연산
import java.util.*;
class Solution {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        //인덱스 값이여서
        col -= 1;

        // 2. 정렬
        //람다식에서는 변하는 않는 변수여야한다
        //그러므로 final을 쓰거나 새로운 변수에 할당해주어야 한다.
        int finalCol = col;
        Arrays.sort(data, (o1, o2) -> {
            if (o1[finalCol] == o2[finalCol]) return o2[0] - o1[0];
            return o1[finalCol] - o2[finalCol];
        });

        // 3. S_i 합 구하기
        for (int i = row_begin; i <= row_end; i++) {

            //람다식이여서 새로운 변수 할당
            int finalI = i;
            int dataTotal = Arrays.stream(data[i-1])
                    .map(j -> j % finalI)
                    .sum();

            // 4. XOR한 값 저장
            answer = (answer ^ dataTotal);
        }

        return answer;
    }
}