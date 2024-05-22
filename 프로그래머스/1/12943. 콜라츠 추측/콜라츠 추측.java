class Solution {
    public int solution(int num) {
        int answer = 0;
        int count = 0;
        // num이 1이 아닐 때까지 반복
        while(num!=1) {
            if (num % 2 == 0) {
                num /= 2;
            }
            else {
                num = (num*3) + 1;
            }
            count++;
         // 400회 이상이면 -1 리턴
            if (count > 400) {
                return -1;
            }
        }
        return count;
    }
}