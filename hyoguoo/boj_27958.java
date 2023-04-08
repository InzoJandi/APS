/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 27958
 * Level: GOLD IV
 * Algorithm: Brute Force / Implementation / Simulation
 */

/* Pseudocode *
총을 쏠 수 있는 모든 경우의 수 생성
각 경우의 수에 대해 점수를 구함
    총을 쏘는 행 번호 배열을 순회하며
        총을 쏘는 행 번호 배열의 원소를 행 번호로 하여 가장 왼쪽에 있는 타겟의 열 번호를 구함
        가장 왼쪽에 있는 타겟이 없다면 허공에 쏜 것으로 취급
        보너스 점수를 가진 타겟이라면
            점수 배열의 해당 위치의 값을 점수에 더함
            HP 배열의 해당 위치의 값을 0으로 변경
        타겟을 부수면
            점수 배열의 해당 위치의 값을 점수에 더함
            HP 배열의 해당 위치의 값을 0으로 바꿈
            주위에 추가 타겟 생성
        타겟을 부수지 못하면
            HP만 감소
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetPractice {

    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final static int BASED_BONUS_POINT = 10;
    static int N, BULLET_COUNT;
    static int[] BULLETS_DAMAGE;
    static int[][] TARGET;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(simulate());
    }

    private static int simulate() {
        List<int[]> permutations = getPermutations(N, BULLET_COUNT); // 총을 쏠 수 있는 모든 경우의 수를 구한다.
        int maxScore = 0;

        for (int[] permutation : permutations) {
            int score = getScore(permutation, copyMap(TARGET), copyMap(TARGET)); // 각 경우의 수에 대해 점수를 구함
            maxScore = Math.max(maxScore, score); // 최대 점수 갱신
        }

        return maxScore;
    }

    // 총을 쏘는 행 번호 배열, HP 배열, 점수 배열을 인자로 받아 점수를 반환한다.
    private static int getScore(int[] bullets, int[][] hp, int[][] score) {
        int currentScore = 0;

        for (int x = 0; x < BULLET_COUNT; x++) {
            int i = bullets[x] - 1; // 총을 쏠 행 번호
            int j = getMostLeftIndex(hp, i); // 총을 쏠 열 번호(가장 왼쪽의 타겟만 조준 가능)
            if (j == -1) continue; // 총을 쏠 타겟이 없는 경우 스킵

            int damage = BULLETS_DAMAGE[x]; // 총알의 데미지
            int targetHP = hp[i][j]; // 타겟의 HP
            int targetScore = score[i][j]; // 타겟의 점수

            // 보너스 타겟의 경우 점수를 추가하고 주변에 4개의 타겟이 생기지 않음
            if (targetHP >= BASED_BONUS_POINT) {
                currentScore += targetScore;
                hp[i][j] = 0;
            } else {
                if (damage >= targetHP) { // 타겟을 파괴하는 경우
                    currentScore += targetScore;
                    hp[i][j] = 0; // 타겟 파괴
                    int dividedTarget = targetScore / 4; // 주변에 4개의 타겟이 생김
                    for (int[] direction : DIRECTIONS) {
                        int nextI = i + direction[0];
                        int nextJ = j + direction[1];
                        if (nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= N) continue;
                        if (hp[nextI][nextJ] != 0) continue;
                        hp[nextI][nextJ] = dividedTarget; // 주변 타겟의 HP
                        score[nextI][nextJ] = dividedTarget; // 주변 타겟의 점수
                    }
                } else {
                    hp[i][j] -= damage; // 타겟의 HP만 감소 시킴
                }
            }
        }

        return currentScore; // 점수 반환
    }

    private static int getMostLeftIndex(int[][] map, int i) {
        for (int j = 0; j < N; j++) {
            if (map[i][j] != 0) return j;
        }
        return -1;
    }

    private static int[][] copyMap(int[][] map) {
        int[][] copiedMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }
        return copiedMap;
    }

    // 모든 경우의 수를 구하는 메서드
    private static List<int[]> getPermutations(int x, int n) {
        List<int[]> result = new ArrayList<>();
        int[] nums = new int[n];
        backtrack(result, nums, x, 0);
        return result;
    }

    private static void backtrack(List<int[]> result, int[] nums, int x, int start) {
        if (start == nums.length) {
            result.add(nums.clone());
        } else {
            for (int i = 1; i <= x; i++) {
                nums[start] = i;
                backtrack(result, nums, x, start + 1);
            }
        }
    }


    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        BULLET_COUNT = Integer.parseInt(bufferedReader.readLine());
        TARGET = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] point = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                TARGET[i][j] = point[j];
            }
        }
        BULLETS_DAMAGE = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
