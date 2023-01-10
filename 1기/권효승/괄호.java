/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9012
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parenthesis {
    static final char CLOSE = ')';

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            System.out.println(solution(bufferedReader.readLine()) ? "YES" : "NO");
        }
    }

    private static boolean solution(String input) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (count == 0) {
                if (current == CLOSE) return false;
                count++;
            } else {
                if (current == CLOSE) count--;
                else count++;
            }
        }

        return count == 0;
    }
}
