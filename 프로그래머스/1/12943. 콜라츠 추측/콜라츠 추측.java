class Solution {
    public int solution(int num) {
        int answer = 0;
        int count = 0;
        while(num != 1) { // 1이 아닌 경우에만 루프 실행
            for (count = 1; count < 500; count++) {
                if (num % 2 == 0) {
                    num /= 2;
                } 
                else {
                    num = num * 3 + 1;
                }
                if (num == 1) { // 1에 도달하면 루프 종료
                    break;
                }
            }
            if (count >= 400) { // 500회 반복 시도 후에도 1에 도달하지 못한 경우 -1 반환
                return -1;
            }
        }
        return count;
        
    }
}