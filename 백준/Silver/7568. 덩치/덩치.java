import java.util.*;
public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int[][] arr = new int[x][2];

        //2차원 배열에 몸무게, 키 집어넣기
        for(int i=0; i<x; i++) {
            arr[i][0] = sc.nextInt();  //몸무게
            arr[i][1] = sc.nextInt();  //키
        }

        //2차원 배열 서로 비교
        for(int j=0; j<x; j++) {
            //순위는 1로 초기화
            int rank = 1;

            for(int k=0; k<x; k++) {
                //j와k가 같다면 나 자신을 비교하는 것이므로 무시
                if(j==k) {
                    continue;
                }
                else {
                    if(arr[j][0]<arr[k][0] && arr[j][1]<arr[k][1]) {  //뒷 사람보다 덩치가 작다 = 순위가 밀려난다
                        rank++;
                    }
                }
            }
            System.out.print(rank + " ");
        }
	}
}