class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        // j는 left~right
        // 반복문 i를 통해 약수 구하기
        for (int j=left;j<=right;j++) {
            int count = 0;  // 변수 count 초기화
            for (int i=1;i<=right;i++) {
                if (j % i == 0) {
                    count++;
                }
            }
            if (count % 2 ==0) {
                answer += j;
            }
            else {
                answer -= j;
            }
        }
        return answer;
    }
}
