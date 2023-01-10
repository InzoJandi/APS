/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2748
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumber {

    private static long[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(bufferedReader.readLine());

        long result = getFibonacci(index);
        System.out.println(result);
    }

    public static void setTableArray(int index) {
        table = new long[index + 1];
        table[0] = 0;
        table[1] = 1;
    }

    public static long getFibonacci(int index) {
        setTableArray(index);
        for (int i = 2; i <= index; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[index];
    }
}
