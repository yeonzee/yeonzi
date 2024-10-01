//각 개인정보의 약정날짜를 담은 리스트 생성
//월이 12를 넘는지 / day가 1인지 28인지
//today와 비교

import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<String> list = new ArrayList<>();

        for (String p : privacies) {
            String[] temp = p.split(" ");
            String p_date = temp[0];
            String p_type = temp[1];

            for (String t : terms) {
                String[] term = t.split(" ");
                String t_type = term[0];
                int t_month = Integer.parseInt(term[1]);

                if (p_type.equals(t_type)) {
                    String[] dd = p_date.split("\\.");
                    int year = Integer.parseInt(dd[0]);
                    int month = Integer.parseInt(dd[1]);
                    int day = Integer.parseInt(dd[2]);

                    // term_month를 더한 후 날짜 계산
                    month += t_month;
                    year += (month - 1) / 12; // 내년으로 넘어가는 경우를 처리
                    month = (month - 1) % 12 + 1; // 1~12월로 조정

                    if (day == 1) {
                        // 1일이면 전달의 마지막 날 (28일)로 표기
                        month -= 1;
                        if (month == 0) {
                            month = 12;
                            year -= 1;
                        }
                        list.add(year + "." + month + ".28");
                    }
                    else if (day == 28) {
                        // 28일이면 다음 달 1일로 표기
                        month += 1;
                        if (month == 13) {
                            month = 1;
                            year += 1;
                        }
                        list.add(year + "." + month + ".01");
                    } 
                    else {
                        // 그 외의 경우 하루 전 날짜로 설정
                        list.add(year + "." + month + "." + (day - 1));
                    }
                }
            }
        }

        // today 날짜 분리
        String[] t = today.split("\\.");
        int t_year = Integer.parseInt(t[0]);
        int t_month = Integer.parseInt(t[1]);
        int t_day = Integer.parseInt(t[2]);

        // 만료일을 저장할 리스트
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            String[] l = list.get(i).split("\\.");
            int l_year = Integer.parseInt(l[0]);
            int l_month = Integer.parseInt(l[1]);
            int l_day = Integer.parseInt(l[2]);

            // 만료일이 today 이전인지 확인
            if (l_year < t_year || (l_year == t_year && l_month < t_month) || (l_year == t_year && l_month == t_month && l_day < t_day)) {
                arr.add(i + 1);
            }
        }

        // 결과 배열로 변환
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }
}
