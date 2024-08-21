import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
        //check함수를 통해 그룹 단어인지 확인
        int N = sc.nextInt();
        int count = 0;

        for(int i=0; i<N; i++) {
            if(check()) {  //그룹 단어이다
                count++;
            }
        }
        System.out.print(count);
    }

    public static boolean check() {
        boolean[] ck = new boolean[26];  //알파벳
        //첫번째값
        int prev = 0;
        String str = sc.next();  //next.Line()은 안됨 입력 버퍼에 남아있는 개행문자때문에

        for(int i=0; i<str.length(); i++) {
            int now = str.charAt(i);

            //앞의 문자와 i번째 문자가 같지 않다면
            if(prev != now) {

                //처음 나오는 문자인 경우
                if(!ck[now-'a']) {
                    ck[now-'a'] = true;  //방문처리
                    prev = now;  //앞의 문자를 지금의 문자로 갱신
                    
                }

                else {  //이미 나온 문자인 경우는 그룹단어가 아님
                    return false;
                }
            }

            // //앞의 문자와 i번째 문자가 같다면 (연속된 문자일 경우) 무시
            // else {
            //     continue;
            // }
        }
        return true;
    }
}