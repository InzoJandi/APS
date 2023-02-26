/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1967
 * Level: GOLD IV
 * Algorithm: Graph
 */

/* Pseudocode *
for 시작노드 = 1 to length
    visited = new boolean[length + 1]
    dfs(시작노드, 0)

dfs(시작 노드, 거리)
    visited[시작 노드] = true
    for 인접 노드 in 인접 노드 리스트
        if !visited[인접 노드]
            dfs(인접 노드, 거리 + 인접 노드 거리)
    diameter = max(diameter, 거리)
*/

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiameterOfTree {

    static List<Node>[] adjacencyList;
    static boolean[] visited;
    static int diameter;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        adjacencyList = new ArrayList[length + 1];
        for (int i = 1; i <= length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < length - 1; i++) {
            int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = info[0];
            int to = info[1];
            int distance = info[2];
            // 인접 리스트에 양방향으로 추가
            adjacencyList[from].add(new Node(to, distance));
            adjacencyList[to].add(new Node(from, distance));
        }

        // 모든 노드를 시작 노드로 하여 dfs 수행
        for (int i = 1; i <= length; i++) {
            visited = new boolean[length + 1];
            dfs(i, 0);
        }
        System.out.println(diameter);
    }

    private static void dfs(int start, int distance) {
        visited[start] = true; // 방문 처리
        for (Node node : adjacencyList[start]) { // 인접 노드 탐색
            if (!visited[node.dist]) { // 방문하지 않은 노드인 경우
                dfs(node.dist, distance + node.distance); // dfs 수행
            }
        }
        diameter = Math.max(diameter, distance); // 최대 거리인 경우 갱신
    }

    static class Node {
        int dist;
        int distance;

        public Node(int dist, int distance) {
            this.dist = dist;
            this.distance = distance;
        }
    }
}
