import java.util.*;
public class Main {
    public static void solution() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        in.close();
        Arrays.sort(arr);

        System.out.print(arr[0]+ " " + arr[n-1]);
    }
    
    public static void main(String[] args) {
        solution();
    }
}