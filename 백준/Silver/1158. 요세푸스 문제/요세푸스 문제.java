import java.util.*;
public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            q.add(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        
        while(q.size() > 1) {
            for(int i=0; i<K-1; i++) {
                int a = q.poll();
                q.offer(a);
            }

            sb.append(q.poll());
            sb.append(", ");
        }
        sb.append(q.poll());
        sb.append(">");
        System.out.print(sb);


	}
}