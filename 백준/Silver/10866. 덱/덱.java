import java.util.*;
public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();  //개행 없애기

        Deque<String> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<x; i++) {
            String str = sc.nextLine();
            String[] arr = str.split(" ");

            if(arr[0].equals("push_front")) {
                dq.addFirst(arr[1]);
            }
            
            else if(arr[0].equals("push_back")) {
                dq.addLast(arr[1]);
            }

            else if(arr[0].equals("pop_front")) {
                if(dq.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(dq.pollFirst()).append("\n");
                } 
            }

            else if(arr[0].equals("pop_back")) {
                if(dq.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(dq.pollLast()).append("\n");
                }
            }

            else if(arr[0].equals("size")) {
                sb.append(dq.size()).append("\n");
            }

            else if(arr[0].equals("empty")) {
                if(dq.isEmpty()) {
                    sb.append(1).append("\n");
                }
                else {
                    sb.append(0).append("\n");
                }
            }

            else if(arr[0].equals("front")) {
                if(dq.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(dq.peekFirst()).append("\n");
                }
            }

            else if(arr[0].equals("back")) {
                if(dq.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(dq.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
	}
}