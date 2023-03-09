/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2493
 * Level: GOLD V
 * Algorithm: Stack
 */

/* Pseudocode *
수신 가능한 탑의 인덱스를 찾는 문제
수신 가능한 탑이란 자신보다 높은 탑이 있으면 그 탑의 인덱스를, 없으면 0을 출력하는 문제(같은 높이의 탑은 존재하지 않음)

stack.push(첫 번째 탑)
result.add(0) // 첫 번째 탑은 수신 가능한 탑이 없으므로 0을 추가
for index 1 to heights.length
    height = 현재 탑의 높이
    higherTowerIndex = 스택에 있는 탑 중 현재 탑보다 높은 탑의 인덱스
    result.add(higherTowerIndex)
    stack.push(new Tower(index + 1, height))
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Towers {

    static final Stack<Tower> stack = new Stack<>();
    static final List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine(); // 입력받은 숫자의 개수는 사용하지 않음
        int[] heights = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 입력받은 숫자 배열
        solution(heights);
        System.out.println(result.toString().replaceAll("[\\[\\],]", "")); // List 자료구조를 [1, 2, 3] 형태의 문자열로 변환
    }

    private static void solution(int[] heights) {
        stack.push(new Tower(1, heights[0])); // 가장 첫 타워를 스택에 넣음
        result.add(0); // 가장 첫 타워는 수신 가능한 타워가 없으므로 0을 추가
        for (int index = 1; index < heights.length; index++) { // 두 번째 타워부터 마지막 타워까지 순회
            int height = heights[index]; // 현재 타워의 높이
            int higherTowerIndex = getHigherTowerIndex(height); // 현재 타워보다 높은 타워의 인덱스
            result.add(higherTowerIndex); // 현재 타워보다 높은 타워의 인덱스를 결과에 추가
            stack.push(new Tower(index + 1, height)); // 현재 타워를 스택에 넣음, 문제에서 인덱스는 1부터 시작하므로 index + 1
        }
    }

    private static int getHigherTowerIndex(int height) {
        while (!stack.isEmpty()) { // 스택이 빌 때까지 반복
            Tower peekTower = stack.peek(); // 스택의 가장 위에 있는 타워
            if (peekTower.height > height) return peekTower.index; // 현재 타워보다 높은 타워라면 인덱스를 반환
            stack.pop(); // 현재 타워보다 높은 타워가 없다면 스택에서 제거하여 앞의 타워를 확인
        }

        return 0; // 스택이 비었다면 수신 가능한 타워가 없으므로 0을 반환
    }

    static class Tower {
        int index;
        int height;

        public Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}
