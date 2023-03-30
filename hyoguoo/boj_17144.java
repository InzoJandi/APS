/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17144
 * Level: GOLD IV
 * Algorithm: Implementation / Simulation
 */

/* Pseudocode *
for 0 to TIME
    미세먼지 확산
    공기청정기 작동
    미세먼지 맵에 반영
미세먼지 총량 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoodByeDust {

    final static List<Dust> dustList = new ArrayList<>();
    final static int AIR_CLEANER = -1;
    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int AIR_CLEANER_TOP;
    static int AIR_CLEANER_BOTTOM;
    static int N, M, TIME;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        simulation();
        System.out.println(getTotalAmount());
    }

    private static void simulation() {
        for (int time = 0; time < TIME; time++) {
            spread(); // 미세먼지 확산
            clean(); // 공기청정기 작동
            mapRelocation(); // 미세먼지 맵에 반영
        }
    }

    private static void spread() {
        List<Dust> spreadDustList = new ArrayList<>(); // 확산된 미세먼지 리스트

        for (Dust dust : dustList) { // 미세먼지 리스트 순회
            int x = dust.x;
            int y = dust.y;
            int amount = dust.amount;
            int spreadAmount = amount / 5;

            int spreadCount = 0;
            for (int[] direction : DIRECTIONS) { // 4방향으로 확산
                int spreadX = x + direction[0];
                int spreadY = y + direction[1];
                if (spreadX < 0 || spreadX >= N || spreadY < 0 || spreadY >= M) continue;
                if (map[spreadX][spreadY] == AIR_CLEANER) continue;
                spreadDustList.add(new Dust(spreadX, spreadY, spreadAmount)); // 확산된 미세먼지 리스트에 추가
                spreadCount++; // 확산된 방향 개수 증가
            }

            map[x][y] -= spreadAmount * spreadCount; // 확산된 미세먼지만큼 미세먼지 양 감소
            dust.amount = map[x][y]; // 미세먼지 리스트에 있는 미세먼지 양 갱신
        }

        addSpreadDustToMap(spreadDustList);  // 확산된 미세먼지 맵에 반영
        regenerateDustListFromMap(); // 미세먼지 리스트 갱신
    }

    private static void regenerateDustListFromMap() {
        dustList.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) dustList.add(new Dust(i, j, map[i][j]));
            }
        }
    }

    private static void addSpreadDustToMap(List<Dust> spreadDustList) {
        for (Dust dust : spreadDustList) {
            map[dust.x][dust.y] += dust.amount;
        }
    }

    private static void clean() {
        for (int index = dustList.size() - 1; index >= 0; index--) {
            Dust dust = dustList.get(index);

            // 규칙에 맞게 미세먼지 이동 및 리스트에서 삭제
            if ((dust.x == AIR_CLEANER_TOP - 1 || dust.x == AIR_CLEANER_BOTTOM + 1) && dust.y == 0) {
                dustList.remove(index);
            } else if (dust.x == AIR_CLEANER_TOP && dust.y > 0) {
                if (dust.y == M - 1) dust.x--;
                else dust.y++;
            } else if (dust.x == AIR_CLEANER_BOTTOM && dust.y > 0) {
                if (dust.y == M - 1) dust.x++;
                else dust.y++;
            } else if ((dust.x == 0 && dust.y > 0) || (dust.x == N - 1 && dust.y > 0)) {
                dust.y--;
            } else if (dust.y == M - 1) {
                if (dust.x < AIR_CLEANER_TOP) dust.x--;
                else if (dust.x > AIR_CLEANER_BOTTOM) dust.x++;
            } else if (dust.y == 0) {
                if (dust.x < AIR_CLEANER_TOP) dust.x++;
                else dust.x--;
            }
        }
    }

    private static void mapRelocation() {
        map = new int[N][M]; // 맵 초기화
        for (Dust dust : dustList) {
            map[dust.x][dust.y] = dust.amount; // 미세먼지 리스트에 있는 미세먼지들 맵에 반영
        }
        // 공기청정기 위치 맵에 반영
        map[AIR_CLEANER_TOP][0] = AIR_CLEANER;
        map[AIR_CLEANER_BOTTOM][0] = AIR_CLEANER;
    }

    private static int getTotalAmount() {
        int totalAmount = 0;
        for (Dust dust : dustList) {
            totalAmount += dust.amount;
        }
        return totalAmount;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        TIME = info[2];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            int[] row = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j];
                if (map[i][j] > 0) dustList.add(new Dust(i, j, map[i][j]));
                if (map[i][j] == AIR_CLEANER) {
                    if (AIR_CLEANER_TOP == 0) AIR_CLEANER_TOP = i;
                    else AIR_CLEANER_BOTTOM = i;
                }
            }
        }
    }

    static class Dust {
        int x;
        int y;
        int amount;

        public Dust(int x, int y, int amount) {
            this.x = x;
            this.y = y;
            this.amount = amount;
        }
    }
}
