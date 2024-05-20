class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double b = 0;
        for (double a : arr) {
            b += a;
        }
        return  b / arr.length;
    }
}