/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 13164
 * Level: GOLD V
 * Algorithm: Greedy
 */

/* Pseudocode *
K명의 아이들을 키 순서대로 줄을 세우고, 인접한 두 아이의 키 차이를 모두 더한다.
여기서 키 차이의 합을 최소로 만드는 방법을 찾는 문제
키가 가장 큰 아이와 가장 작은 아이 사이의 키 차이를 제외 시키고 나머지 키 차이들을 모두 더하면 된다.

difference = getDifference(heights);
differnce sort descending;
for i = K - 1 to difference.size() - 1
    sum += difference[i];
print sum;
 */


package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HappyKindergarten {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        final int K = info[1];
        int[] heights = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 아이들의 키 차이를 저장하는 리스트 생성
        List<Integer> difference = getDifference(heights);

        System.out.println(solution(difference, K));
    }

    private static int solution(List<Integer> difference, int K) {
        int offset = getOffsetLargestValues(difference, K);
        int sum = 0;

        // 키 차이가 가장 큰 아이들을 제외 시킨 시작 지점부터 끝까지의 키 차이를 모두 더한다.
        for (int i = offset; i < difference.size(); i++) sum += difference.get(i);
        return sum;
    }

    private static int getOffsetLargestValues(List<Integer> difference, int K) {
        // 키 차이를 내림차순으로 정렬
        difference.sort(Collections.reverseOrder());
        // 높은 키 차이를 제외 시키기 위한 오프셋 값
        return K - 1;
    }

    private static List<Integer> getDifference(int[] heights) {
        List<Integer> difference = new ArrayList<>();
        for (int i = 0; i < heights.length - 1; i++) difference.add(heights[i + 1] - heights[i]);
        return difference;
    }
}
