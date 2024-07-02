// #처리하는 것 잊지 말기!!!
import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        ArrayList<String> answerList = new ArrayList<>();
        int maxDuration = 0; 
        
        for(String str:musicinfos) {
            String[] music = str.split(",");
            
            String[] start = music[0].split(":");
            int start_h = Integer.parseInt(start[0]);
            int start_m = Integer.parseInt(start[1]);
            
            String[] end = music[1].split(":");
            int end_h = Integer.parseInt(end[0]);
            int end_m = Integer.parseInt(end[1]);
            
            //곡이 진행되는 시간
            int time = (end_h-start_h) * 60 + (end_m - start_m);
            
            // 곡
            String melody = music[3];
            
            //테케 34번에 B#이 있어서 추가함
            // '#' 문자가 포함된 경우 변환 처리
            String modifiedMelody = melody.replaceAll("A#", "a")
                                    .replaceAll("C#", "c")
                                    .replaceAll("D#", "d")
                                    .replaceAll("F#", "f")
                                    .replaceAll("G#", "g")
                                    .replaceAll("B#", "m");
            
            // m에서도 변환 처리
            String modifiedM = m.replaceAll("A#", "a")
                                .replaceAll("C#", "c")
                                .replaceAll("D#", "d")
                                .replaceAll("F#", "f")
                                .replaceAll("G#", "g")
                                .replaceAll("B#", "m");

            // 진행되는 곡
            StringBuilder song = new StringBuilder();
            for (int i = 0; i < time; i++) {
                song.append(modifiedMelody.charAt(i % modifiedMelody.length()));
            }
            
            String fullSong = song.toString();
            
            // m이 진행되는 곡 안에 포함되어 있다면 제목을 담은 list
            if (fullSong.contains(modifiedM)) {
                if (time > maxDuration) {
                    maxDuration = time;
                    answer = music[2];
                } 
                else if (time == maxDuration) {
                // 재생 시간이 같은 경우 먼저 입력된 음악을 선택
                    if (answer.equals("None")) {
                        answer = music[2];
                    }
                }
            }
        }
        return answer;
    }
}