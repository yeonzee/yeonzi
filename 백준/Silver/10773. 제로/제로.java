import java.util.*;
public class Main {
	public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        for(int i=0; i<x; i++) {
            int n = sc.nextInt();

            if(n != 0) {
                stack.push(n);
            }
            else {  //0일 경우
                stack.pop();
            }
        }
        
        int size = stack.size();
        for(int j=0; j<size; j++) {
            answer += stack.pop();
        }

        System.out.print(answer);
	}
}