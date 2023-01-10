/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15903
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CardCombinationGame {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int combination = numbers[1];
        String[] cards = bufferedReader.readLine().split(" ");
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        for (String card : cards) priorityQueue.add(Long.parseLong(card));
        combinationCards(priorityQueue, combination);
        System.out.println(getSum(priorityQueue));
    }

    private static long getSum(PriorityQueue<Long> priorityQueue) {
        long sum = 0;
        for (long i : priorityQueue) sum += i;
        return sum;
    }

    private static void combinationCards(PriorityQueue<Long> priorityQueue, int combination) {
        for (int i = 0; i < combination; i++) {
            long first = priorityQueue.poll();
            long second = priorityQueue.poll();
            priorityQueue.add(first + second);
            priorityQueue.add(first + second);
        }
    }
}
