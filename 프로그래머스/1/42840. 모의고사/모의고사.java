import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        //3명의 수포자 정답의 개수를 담을 배열
        int[] list = new int[3];
        
        //각 수포자의 답이 담긴 배열
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] thr = {3,3,1,1,2,2,4,4,5,5};
        
        //answers[i]의 값이 1,2,3번의 수포자들의 정답과 일치한지 비교
        //배열.length로 나누어 나머지 값을 인덱스로 하는 값 반환
        //else if가 아닌 if로 해야 함!!
        for (int i=0;i<answers.length;i++) {
            if(answers[i]==one[i%one.length]) {
                list[0]++;
            }
            if(answers[i]==two[i%two.length]) {
                list[1]++;
            }
            if(answers[i]==thr[i%thr.length]) {
                list[2]++;
            }
        }
 
        //최대값 뽑기
        int max=0;
        for (int j:list) {
            max = Math.max(j,max);
        }
        
        //max값과 일치한 인덱스(수포자 번호)를 arr리스트에 저장
        ArrayList<Integer> arr = new ArrayList<>();
        for (int k=0;k<3;k++) {
            if(list[k]==max) {
                arr.add(k+1);
            }
        }
        //배열로 변환
        int[] answer = new int[arr.size()];
        for (int num=0;num<arr.size();num++) {
            answer[num] = arr.get(num);
        }
        
        return answer;
    }
}