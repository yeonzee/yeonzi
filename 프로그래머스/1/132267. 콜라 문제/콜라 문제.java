class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int count = 0;
        while(n>=a) {
            int k = n % a;
            n = (n / a) * b;
            count += n;
            n += k;
        }
        return count;
    }
}