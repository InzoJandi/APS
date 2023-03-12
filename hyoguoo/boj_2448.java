/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11779
 * Level: GOLD IV
 * Algorithm: Backtracking
 */

/* Pseudocode *
스도쿠 정답을 출력하는 문제

입력해야할 칸의 좌표 리스트 생성

solution(index) {
    모든 칸을 채웠을 경우
        결과 출력
        return
    for (1부터 9까지의 숫자)
        채워야 할 칸의 좌표
        가능한 경우
            해당 칸에 숫자를 넣음
            solution(index + 1) // 다음 칸을 채우기 위해 재귀 호출
            해당 칸을 초기화
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {

    static final int SIZE = 9;
    static final int[][] board = new int[SIZE][SIZE];
    static final List<Zero> zeroList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < SIZE; i++) {
            board[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) zeroList.add(new Zero(i, j)); // 채워야 할 칸의 좌표를 저장
            }
        }

        solution(0);
    }

    private static void solution(int index) {
        if (index == zeroList.size()) { // 모든 칸을 채웠을 경우
            printResult(); // 결과 출력
            return;
        }

        for (int i = 1; i <= 9; i++) { // 1부터 9까지의 숫자를 넣어보며 가능한지 확인
            Zero zero = zeroList.get(index); // 채워야 할 칸의 좌표
            if (checkPossible(zero.x, zero.y, i)) { // 가능한 경우
                board[zero.x][zero.y] = i; // 해당 칸에 숫자를 넣음
                solution(index + 1); // 다음 칸으로 넘어감
                board[zero.x][zero.y] = 0; // 다음 경우를 위해 해당 칸을 초기화
            }
        }
    }

    private static void printResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                stringBuilder.append(board[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        System.exit(0);
    }

    private static boolean checkPossible(int x, int y, int reference) {
        // 가로, 세로, 3x3 영역을 넣어야 할 숫자와 중복되는지 확인
        return checkWidth(x, reference) && checkHeight(y, reference) && checkArea(x, y, reference);
    }

    private static boolean checkArea(int x, int y, int reference) {
        int offsetX = getOffset(x);
        int offsetY = getOffset(y);
        // 3x3 영역을 확인
        for (int i = offsetX; i < offsetX + 3; i++) {
            for (int j = offsetY; j < offsetY + 3; j++) {
                if (board[i][j] == reference) return false;
            }
        }
        return true;
    }

    // 3x3 영역의 시작 좌표를 반환
    private static int getOffset(int n) {
        return (n / 3) * 3;
    }

    // 가로 확인
    private static boolean checkWidth(int x, int reference) {
        for (int i = 0; i < SIZE; i++) {
            if (board[x][i] == reference) return false;
        }
        return true;
    }

    // 세로 확인
    private static boolean checkHeight(int y, int reference) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][y] == reference) return false;
        }
        return true;
    }
}

// 채워야 할 칸의 좌표를 저장할 클래스
class Zero {
    int x;
    int y;

    public Zero(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
