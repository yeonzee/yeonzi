class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        // a[i] * b[i]를 answer에 더하기
        for (int i = 0;i<a.length;i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}