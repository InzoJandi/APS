/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2639
 * Level: GOLD V
 * Algorithm: String
 */

/* Pseudocode *
1. :: -> :0000:0000:0000:0000:0000:0000:0000:로 변환하여 StringBuilder에 저장
2. 초과 생성 된 :0000 제거
3. 23 -> 0023 형태로 변환
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IPv6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String v6 = bufferedReader.readLine();
        String v4 = convertV4FromV6(v6);

        System.out.println(v4);
    }

    private static String convertV4FromV6(String v6) {
        String replaced = processDoubleColon(v6); // :: -> :0000:0000:0000:0000:0000:0000:0000:
        String[] splitString = replaced.split(":");
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : splitString) {
            String addString = padLeft(string, "0", 4); // 23 -> 0023
            stringBuilder.append(addString).append(":"); // 0023:
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1); // 끝의 : 제거

        return stringBuilder.toString();
    }

    private static String processDoubleColon(String v6) {
        // :: -> :0000:0000:0000:0000:0000:0000:0000:로 변환하여 StringBuilder에 저장
        StringBuilder stringBuilder = new StringBuilder(v6.replace("::", ":0000:0000:0000:0000:0000:0000:0000:"));

        if (stringBuilder.charAt(0) == ':') stringBuilder.deleteCharAt(0); // 맨 앞이 : 이면 제거
        String string = stringBuilder.toString();
        int length = string.split(":").length; // :로 나눈 문자열의 개수

        // :0000이 초과되어 생성된 문자열 제거
        for (int i = length; i > 8; i--) {
            string = string.replaceFirst(":0000", "");
        }

        return string;
    }


    private static String padLeft(String string, String addString, int length) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length - string.length(); i++) stringBuilder.append(addString);
        stringBuilder.append(string);

        return stringBuilder.toString();
    }
}
