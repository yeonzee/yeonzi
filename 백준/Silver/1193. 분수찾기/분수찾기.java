import java.util.*;
public class Main {
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
 
		int count = 1, sum = 0;
 
		while (true) {
			// 직전 대각선 누적합 + 해당 대각선 개수 이용한 범위 판별
			if (X <= sum + count) {	
				
				if (count % 2 == 1) {	// 대각선의 개수가 홀수라면 
					// 분자가 큰 수부터 시작
					// 분자는 대각선상 내의 블럭 개수 - (X 번째 - 직전 대각선까지의 블럭 개수 - 1) 
					// 분모는 X 번째 - 직전 대각선까지의 블럭 개수
					System.out.print((count - (X - sum - 1)) + "/" + (X - sum));
					break;
				} 
				
				else {	// 대각선상의 블럭의 개수가 짝수라면 
					// 홀수일 때의 출력을 반대로 
					System.out.print((X - sum) + "/" + (count - (X - sum - 1)));
					break;
				}
 
			} else {
				sum += count;
				count++;
			}
		}
	}
}