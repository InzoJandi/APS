/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16235
 * Level: GOLD III
 * Algorithm: Implementation / Simulation
 */

/* Pseudocode *
treeDeque = new deque
deadTreeQueue = new queue

for i : N
    for j : N
        map[i][j] = 5
        FOODS[i][j] = A[i][j]
for i : TREE_COUNT
    treeDeque.add(new Tree(x, y, age))

for i : TARGET_YEAR // 코드 주석 참고
    spring()
    summer()
    fall()
    winter()

print(treeDeque.size())
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeInvestment {

    final static int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    final static Deque<Tree> treeDeque = new ArrayDeque<>();
    final static Queue<Tree> deadTreeQueue = new LinkedList<>();
    static int N;
    static int[][] map;
    static int[][] FOODS;
    static int TREE_COUNT;
    static int TARGET_YEAR;

    public static void main(String[] args) throws IOException {
        init(); // 입력 및 초기화
        simulation();

        System.out.println(treeDeque.size());
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Tree> treeList = new ArrayList<>(); // deque 삽입 전 정렬을 위해 사용하는 리스트
        N = info[0];
        TREE_COUNT = info[1];
        TARGET_YEAR = info[2];

        map = new int[N][N];
        FOODS = new int[N][N];
        for (int i = 0; i < N; i++) {
            FOODS[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(map[i], 5); // 문제에서 제시한 초기 양분 5 세팅
        }
        for (int i = 0; i < TREE_COUNT; i++) {
            int[] treeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            treeList.add(new Tree(treeInfo[0] - 1, treeInfo[1] - 1, treeInfo[2])); // 문제에서 제시한 좌표는 1부터 시작하므로 1씩 빼줌
        }

        treeList.sort(Comparator.comparingInt(o -> o.age)); // 나이가 어린 순으로 정렬
        treeDeque.addAll(treeList); // 정렬된 나무들을 deque에 넣어줌(deque는 정렬이 불가능)
    }


    private static void simulation() {
        for (int year = 1; year <= TARGET_YEAR; year++) {
            spring();
            summer();
            fall();
            winter();
        }
    }

    private static void spring() {
        List<Tree> treeList = new ArrayList<>(); // 양분을 먹고 나이가 1 증가한 나무들을 저장하는 리스트
        while (!treeDeque.isEmpty()) {
            Tree tree = treeDeque.pollFirst();
            if (map[tree.x][tree.y] >= tree.age) {
                map[tree.x][tree.y] -= tree.age;
                tree.age++;
                treeList.add(tree); // 양분을 먹고 나이가 1 증가한 나무들은 treeList에 저장
            } else {
                deadTreeQueue.add(tree); // 양분을 먹지 못한 나무들은 deadTreeQueue에 저장
            }
        }

        treeDeque.addAll(treeList); // treeList에 저장된 나무들을 다시 treeDeque에 넣어줌
    }

    private static void summer() {
        while (!deadTreeQueue.isEmpty()) {
            Tree tree = deadTreeQueue.poll();
            map[tree.x][tree.y] += tree.age / 2; // 죽은 나무들의 나이를 2로 나눈 값만큼 양분으로 추가
        }
    }

    private static void fall() {
        List<Tree> babyTreeList = new ArrayList<>(); // 번식한 나무들 주위에 생긴 나이가 1인 나무들을 저장하는 리스트
        List<Tree> existTreeList = new ArrayList<>(); // 이미 존재하던 나무들을 저장하는 리스트
        while (!treeDeque.isEmpty()) {
            Tree tree = treeDeque.pollFirst(); // treeDeque에서 나무를 하나씩 꺼내서
            if (tree.age % 5 == 0) {
                for (int[] direction : DIRECTIONS) { // 주위 8칸에 나이가 1인 나무를 추가
                    int x = tree.x + direction[0];
                    int y = tree.y + direction[1];
                    if (x < 0 || x >= N || y < 0 || y >= N) continue; // 범위를 벗어나면 저장하지 않고 continue
                    babyTreeList.add(new Tree(x, y, 1)); // 번식한 나무들 주위에 생긴 나이가 1인 나무들은 babyTreeList에 저장
                }
            }
            existTreeList.add(tree); // 이미 존재하던 나무들은 existTreeList에 저장
        }

        // babyTreeList를 먼저 deque에 넣어 age 순으로 정렬되도록 함
        treeDeque.addAll(babyTreeList); // babyTreeList에 저장된 나무들을 다시 treeDeque에 넣어줌
        treeDeque.addAll(existTreeList); // existTreeList에 저장된 나무들을 다시 treeDeque에 넣어줌
    }

    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += FOODS[i][j]; // 겨울에는 땅에 양분을 추가
            }
        }
    }

    static class Tree {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }
    }
}
