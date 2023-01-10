/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1978
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        int[] numberArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = countPrimeNumber(numberArray, length);
        System.out.println(count);
    }

    public static int countPrimeNumber(int[] numberArray, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (isPrime(numberArray[i])) count++;
        }
        return count;
    }

    public static boolean isPrime(int number) {
        if (number == 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
