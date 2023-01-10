/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1000
 * Level: Bronze V
 * Algorithm: Implementation
 */

/* Pseudocode *
입력 받은 값을 공백으로 분리
분리된 값을 정수로 변환
더한 값 출력
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" "); // 입력을 받아 공백으로 분리

        // 분리 된 문자열을 정수로 변환
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        System.out.println(a + b);
    }
}
