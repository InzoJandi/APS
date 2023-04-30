/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 42888
 * Level: 2
 * Algorithm: Queue
 */

/* Pseudocode *
두 개의 큐 합을 절반으로 나눈 값과 같아질 때까지 큐의 값을 서로 이동

while (큐 하나의 합이 절반으로 나눈 값과 같지 않을 때까지)
    if 큐의 합이 절반으로 나눈 값보다 크다면
        큐에서 값을 하나 빼서 다른 큐에 삽입
    else
        다른 큐에서 값을 하나 빼서 큐에 삽입
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MakeTwoQueueSumEqual {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    long sum1, sum2, sum, average;
    int size;

    public int solution(int[] numbers1, int[] numbers2) {
        init(numbers1, numbers2);
        if (sum % 2 != 0) return -1; // 두 배열의 합이 홀수인 경우 -1 반환

        int count = 0;

        while (sum1 != average) { // sum1이 average와 같아질 때까지 반복
            count++;
            if (sum1 > average) delete(); // queue1의 값을 queue2로 이동
            else add(); // queue2의 값을 queue1로 이동
            if (count > (size) * 2) return -1; // 무한 루프 감지 시 -1 반환
        }

        return count;
    }

    private void add() {
        int numberB = queue2.remove();
        sum1 += numberB;
        sum2 -= numberB;
        queue1.add(numberB);
    }

    private void delete() {
        int numberA = queue1.remove();
        sum1 -= numberA;
        sum2 += numberA;
        queue2.add(numberA);
    }

    private void init(int[] numbers1, int[] numbers2) {
        sum1 = getArraySum(numbers1);
        sum2 = getArraySum(numbers2);
        sum = sum1 + sum2;
        average = sum / 2;
        queue1 = getQueue(numbers1);
        queue2 = getQueue(numbers2);통
        size = numbers1.length + numbers2.length;
    }

    private Queue<Integer> getQueue(int[] numbers) {
        Queue<Integer> queue = new LinkedList<>();
        for (int number : numbers) queue.add(number);

        return queue;
    }

    private long getArraySum(int[] array) {
        return Arrays.stream(array).sum();
    }
}
