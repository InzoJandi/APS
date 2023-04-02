/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 42888
 * Level: 1
 * Algorithm: Implementation
 */

/* Pseudocode *
Map의 특성을 이용하여 유저 아이디와 닉네임을 매핑
매핑된 정보를 이용하여 답을 생성
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatRoom {

    final static String ENTER = "Enter";
    final static String LEAVE = "Leave";
    final static String ENTER_MESSAGE = "님이 들어왔습니다.";
    final static String LEAVE_MESSAGE = "님이 나갔습니다.";

    public String[] solution(String[] record) {
        Map<String, String> userMap = getUserInfo(record); // 유저 아이디와 닉네임 매핑
        List<String> answer = getAnswer(record, userMap); // 답 생성

        return answer.stream().map(String::valueOf).toArray(String[]::new); // 문제가 원하는 형식으로 변환 List<String> -> String[]
    }

    private Map<String, String> getUserInfo(String[] record) {
        final Map<String, String> userInfo = new HashMap<>();
        for (String message : record) {
            String[] messageArray = message.split(" ");
            if (!messageArray[0].equals(LEAVE)) userInfo.put(messageArray[1], messageArray[2]); // 최근 닉네임으로 생성 및 갱신
        }

        return userInfo;
    }

    private List<String> getAnswer(String[] record, Map<String, String> userInfo) {
        final List<String> answer = new ArrayList<>();

        for (String message : record) {
            String[] messageArray = message.split(" ");
            String nickname = userInfo.get(messageArray[1]);

            // 닉네임을 id로 얻은 후 메시지 생성
            if (messageArray[0].equals(ENTER)) answer.add(nickname + ENTER_MESSAGE);
            if (messageArray[0].equals(LEAVE)) answer.add(nickname + LEAVE_MESSAGE);
        }

        return answer;
    }
}
