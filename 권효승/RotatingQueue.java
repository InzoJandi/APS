/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1021
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RotatingQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] lengthArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = lengthArray[0];
        int[] findNumbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(length, findNumbers));

    }

    private static int solution(int length, int[] findNumbers) {
        int result = 0;
        RotateDeque deque = new RotateDeque(length);

        for (int findNumber : findNumbers) {
            result += rotateAndCounting(deque, findNumber);
            deque.removeFirst();
        }

        return result;
    }

    private static int rotateAndCounting(RotateDeque deque, int findNumber) {
        int count = 0;
        int moveLeft = deque.findIndex(findNumber);
        int moveRight = deque.getSize() - moveLeft;
        if (moveLeft > moveRight) {
            for (int i = 0; i < moveRight; i++) {
                deque.rotateRight();
                count++;
            }
        } else {
            for (int i = 0; i < moveLeft; i++) {
                deque.rotateLeft();
                count++;
            }
        }
        return count;
    }
}


class RotateDeque {
    Deque<Integer> deque;

    public RotateDeque(int length) {
        this.deque = new ArrayDeque<>();
        for (int i = 1; i <= length; i++) this.deque.add(i);
    }

    void rotateLeft() {
        int removedNumber = this.deque.removeFirst();
        this.deque.addLast(removedNumber);
    }

    void rotateRight() {
        int removedNumber = this.deque.removeLast();
        this.deque.addFirst(removedNumber);
    }

    void removeFirst() {
        this.deque.removeFirst();
    }

    int findIndex(int number) {
        int count = 0;
        for (Integer integer : this.deque) {
            if (integer == number) return count;
            count++;
        }
        return -1;
    }

    int getSize() {
        return this.deque.size();
    }
}
