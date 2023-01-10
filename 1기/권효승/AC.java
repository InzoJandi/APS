/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 5430
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC {

    static final String ERROR = "error";
    static final String ROTATION = "R";
    static final String DELETE = "D";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < length; i++) {
            String[] commands = bufferedReader.readLine().split("");
            int arrayLength = Integer.parseInt(bufferedReader.readLine());
            String input = bufferedReader.readLine();
            String[] array = input.substring(1, input.length() - 1).split(",");
            System.out.println(solution(commands, arrayLength, array));
        }
    }

    private static String solution(String[] commands, int arrayLength, String[] array) {
        Deque<Integer> deque = getDeque(arrayLength, array);

        boolean isReverse = false;

        for (String command : commands) {
            switch (command) {
                case ROTATION:
                    isReverse = !isReverse;
                    break;
                case DELETE:
                    if (deque.isEmpty()) return ERROR;
                    if (isReverse) deque.removeLast();
                    else deque.removeFirst();
                    break;
            }
        }

        return getString(deque, isReverse);
    }

    private static Deque<Integer> getDeque(int arrayLength, String[] array) {
        Deque<Integer> deque = new ArrayDeque<>();
        if (arrayLength != 0) {
            for (String s : array) deque.add(Integer.parseInt(s));
        }
        return deque;
    }

    private static String getString(Deque<Integer> deque, boolean isReverse) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (!deque.isEmpty()) {
            if (isReverse) stringBuilder.append(deque.removeLast());
            else stringBuilder.append(deque.removeFirst());
            if (!deque.isEmpty()) stringBuilder.append(",");
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
