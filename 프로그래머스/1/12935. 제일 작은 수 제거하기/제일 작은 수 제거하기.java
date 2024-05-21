class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        int index = 0;
        
        //배열의 길이가 1일 때 배열 -1 리턴
        if (arr.length == 1) {
            return new int[]{-1};
        }
        
        //min변수에 최솟값 넣기
        int min = arr[0];
        for (int i : arr) {
            if (min > i) {
                min = i;
            }
        }
        
        //최솟값이 아닌 값을 answer에 저장
        for (int j : arr) {
            if (j != min) {
                answer[index] = j;
                index++;
            }
        }
        
        return answer;
    }
}