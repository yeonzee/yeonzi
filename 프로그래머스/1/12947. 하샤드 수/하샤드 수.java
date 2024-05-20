class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String str = String.valueOf(x);
        int a = 0;
        int sum = 0;
        
        for (char c : str.toCharArray()) {
            a = Character.getNumericValue(c);
            sum += a;
        }
        
        if (x % sum == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}