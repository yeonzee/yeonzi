class Solution {
    public String solution(int a, int b) {

        //1월1일이 금요일이므로 금요일로 시작되는 day 배열 생성
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        //각 달의 일 수를 담은 배열 생성
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        
        //a달 전의 모든 일 수 더하기
        int answer = 0;
        for(int i=0;i<a-1;i++) {
            answer += month[i];
        }
        
        //index가 0부터 시작하기 때문에 -1 해줘야 함!!!
        answer = answer + b -1;
        return day[answer % 7];
    }
}