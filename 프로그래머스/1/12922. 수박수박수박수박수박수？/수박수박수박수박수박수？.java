class Solution {
    public String solution(int n) {
        String answer = "";
        String[] a = new String[n];
        
        for (int i = 0;i<n;i++) {
            if (i % 2 == 0) {
                a[i] = "수";
            }
            else {
                a[i] = "박";
            }
        }
        
        return String.join("",a);
    }
}