import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //Set을 사용하여 중복 신고 제거
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));

        //신고당한 유저별 신고자 목록 저장
        HashMap<String, HashSet<String>> reportedBy = new HashMap<>();
        
        for (String rep : reportSet) {
            String[] temp = rep.split(" ");
            String reporter = temp[0]; // 신고한 사람
            String reported = temp[1]; // 신고당한 사람

            reportedBy.putIfAbsent(reported, new HashSet<>());
            reportedBy.get(reported).add(reporter); //중복 없이 신고 저장
        }

        //정지된 유저 찾기
        HashMap<String, Integer> mail = new HashMap<>();
        
        for (String reported : reportedBy.keySet()) {
            HashSet<String> reporters = reportedBy.get(reported);
            if (reporters.size() >= k) { //k번 이상 신고당한 경우
                for (String reporter : reporters) {
                    mail.put(reporter, mail.getOrDefault(reporter, 0) + 1);
                }
            }
        }

        //결과 배열 채우기
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mail.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}
