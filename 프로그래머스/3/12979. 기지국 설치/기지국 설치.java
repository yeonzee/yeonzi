//더 짧은 방법
class Solution {
    public int solution(int n, int[] stations, int w) {
        int position = 1;
        int si = 0;
        int answer = 0;
        while(position <= n) {
            if(si < stations.length && stations[si] - w <= position) {
                position = stations[si] + w + 1;
                si++;
            }
            else {
                answer++;
                position += 2*w+1;
            }
        }
        return answer;
    }
}