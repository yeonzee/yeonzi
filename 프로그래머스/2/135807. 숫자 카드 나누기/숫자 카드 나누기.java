//최대공약수..?
import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int ans_a = arrayA[0];
        int ans_b = arrayB[0];
        
        //최대공약수
        for(int i=0;i<arrayA.length;i++) {
            ans_a = gcd(ans_a,arrayA[i]);
            ans_b = gcd(ans_b,arrayB[i]);
        }
        
        boolean validA = true;
        boolean validB = true;
        
        for(int num:arrayA) {
            if(num % ans_b == 0) {
                validB = false;
                break;
            }
        }
        
        for(int num:arrayB) {
            if(num % ans_a == 0) {
                validA = false;
                break;
            }
        }
        
        if(validA && validB) {
            return Math.max(ans_a,ans_b);
        }
        else if(validA) {
            return ans_a;
        }
        else if(validB) {
            return ans_b;
        }
        else {
            return 0;
        }
    }
    
    //최대공약수
    public static int gcd(int a, int b) {
        if(b==0) {
            return a;
        }
        else {
            return gcd(b,a%b);
        }
    }
}