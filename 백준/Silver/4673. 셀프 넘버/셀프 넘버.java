public class Main {
	public static void main(String[] args) {
        //셀프 넘버 확인을 위한 boolean 배열
        //셀프 넘버 맞으면 false, 셀프 넘버 아니면(계산으로 구할 수 있으면) true
        boolean[] check = new boolean[10001];
        
        for(int i=1; i<10001; i++) {
            //셀프넘버 구하기
            int num = self(i);

            //10000이상의 값은 필요하지 않으므로
            if(num <= 10000) {
                check[num] = true;
            }
        }

        for(int j=1; j<10001; j++) {
            if(!check[j]) {  //셀프넘버라면
                System.out.println(j);
            }
        }
    } 
    
    public static int self(int number) {
        int sum = number;

        while(number != 0) {
            sum = sum + (number % 10);
            number = number / 10;
        }
        return sum;
    }
}