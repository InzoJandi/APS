import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1759
 * Level: Gold V
 * Algorithm: Math, Brute Force
 */

/*
글자를 array 로 초기화하여 정렬한다.
dfs 를 수행하며 원하는 길이가 됐을 때, validation 을 통해 조건을 만족하는지 검사한다.
만족할 경우 해당 암호를 list에 추가한다.
list를 출력한다.
 */

public class Main {
    static String[] wordsArr;
    static int password_length;
    static List<String> valifiedPasswordList = new ArrayList<>();

    //모음 세팅
    static List<Character> vowelList = List.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        password_length = Integer.parseInt(s[0]);
        wordsArr = br.readLine().split(" ");
        Arrays.sort(wordsArr);

        for (String item : wordsArr) {
            dfs(item);
        }

        StringBuilder sb = new StringBuilder();
        for (String value : valifiedPasswordList) {
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(String temp) {
        if (temp.length() == password_length) {
            validation(temp);
            return;
        }
        for (String s : wordsArr) {
            //temp의 마지막 문자가 앞으로 올 문자보다 크거나 같으면 사전순이 아니게되므로 continue;
            if (temp.charAt(temp.length() - 1) >= s.charAt(0)) continue;
            dfs(temp + s);
        }
    }

    private static void validation(String target) {
        int consonant = 0;
        int vowel = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (vowelList.contains(c)) {
                vowel++;
            } else {
                consonant++;
            }
        }
        if (consonant >= 2 && vowel >= 1) {
            valifiedPasswordList.add(target);
        }
    }
}
