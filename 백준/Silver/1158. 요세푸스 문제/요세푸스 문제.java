import java.util.*;
public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        //큐
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            q.add(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(q.size() > 1) {  //1인 이유: 마지막에 콤마가 들어가면 안돼서
            for(int i=0; i<K-1; i++) {
                int a = q.poll();
                q.add(a);
            }
            sb.append(q.poll());
            sb.append(", ");
        }

        //q에는 마지막 값만이 남아있다
        sb.append(q.poll());
        sb.append(">");

        System.out.print(sb.toString());
	}
}