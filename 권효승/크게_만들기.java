/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2812
 */

package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MakeBigger {
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] lengthArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numberArray = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int removeLength = lengthArray[1];

        makeBiggerNumberToStack(numberArray, removeLength);

        String result = concatenateStackToString(stack);
        System.out.println(result);
    }

    public static void makeBiggerNumberToStack(int[] numberArray, int count) {
        count = getBiggerStack(numberArray, count);
        popStackNTimes(count);
    }

    public static void popStackNTimes(int count) {
        while (count-- > 0) {
            stack.pop();
        }
    }

    public static int getBiggerStack(int[] numberArray, int removeLength) {
        for (int value : numberArray) {
            if (stack.isEmpty()) {
                stack.push(value);
            } else {
                while (!stack.isEmpty() && removeLength > 0 && stack.peek() < value) {
                    stack.pop();
                    removeLength--;
                }
                stack.push(value);
            }
        }
        return removeLength;
    }

    public static String concatenateStackToString(Stack<Integer> stack) {
        String str = Arrays.toString(stack.toArray());
        return str.substring(1, str.length() - 1).replace(", ", "");
    }
}
