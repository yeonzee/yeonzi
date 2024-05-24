class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int total = 0;
        int count = 0;
        for (int i=0;i<number.length-2;i++) {
            for (int j=i+1;j<number.length-1;j++) {
                for (int k=j+1;k<number.length;k++) {
                    total = number[i]+number[j]+number[k];
                    if (total == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}