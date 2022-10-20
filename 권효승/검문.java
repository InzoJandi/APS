/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2981
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SameRemainder {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        List<Integer> inputNumberList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            inputNumberList.add(number);
        }

        System.out.println(solution(inputNumberList));
    }

    public static String solution(List<Integer> numberList) {
        int minNumber = getMinNumberFromList(numberList);
        List<Integer> reducedList = getReducedList(numberList, minNumber);
        int gcd = getGcdInArray(reducedList, 0, reducedList.size());
        List<Integer> result = getDivisorList(gcd);

        return concatenateListToString(result);
    }

    public static int getMinNumberFromList(List<Integer> numberList) {
        Collections.sort(numberList);
        return numberList.remove(0);
    }


    public static List<Integer> getReducedList(List<Integer> numberList, int minusNum) {
        List<Integer> minusNumberList = new ArrayList<>();
        for (Integer integer : numberList) {
            minusNumberList.add(integer - minusNum);
        }

        return minusNumberList;
    }

    public static int getGcdInArray(List<Integer> list, int start, int length) {
        if (length == 1) return list.get(start);
        else if (length == 2) return getGcd(list.get(start), list.get(start + 1));
        else return getGcd(list.get(start), getGcdInArray(list, start + 1, length - 1));
    }

    public static int getGcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static List<Integer> getDivisorList(int number) {
        List<Integer> divisorList = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                divisorList.add(i);
            }
        }

        return divisorList;
    }

    public static String concatenateListToString(List<Integer> list) {
        String str = list.toString();
        return str.substring(1, str.length() - 1).replace(", ", " ");
    }
}
