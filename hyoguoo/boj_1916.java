/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1916
 * Level: GOLD V
 * Algorithm: Graph / Dijkstra
 */

/* Pseudocode *
가중치가 있는 그래프에서 최소 비용(거리)을 구하는 문제(다익스트라 알고리즘)
주어진 시작점과 도착점의 최소 비용을 구하는 문제

graph = 인접 행렬
costFromStart = 시작점에서 각 정점까지의 최소 비용을 저장하는 배열

dijkstra(start) {
    costFromStart 배열을 모두 무한대로 초기화
    costFromStart[start] = 0
    우선순위 큐에 (0, start)를 넣음
    while (우선순위 큐가 비어있지 않다면) {
        현재 정점 = 우선순위 큐에서 꺼낸 정점
        현재 정점의 최소 비용 = 현재 정점까지의 최소 비용
        for (현재 정점에서 갈 수 있는 모든 정점) {
            if (현재 정점을 거쳐서 갈 수 있는 정점의 최소 비용 < 현재 정점을 거치지 않고 갈 수 있는 정점의 최소 비용) {
                현재 정점을 거쳐서 갈 수 있는 정점의 최소 비용 = 현재 정점을 거치지 않고 갈 수 있는 정점의 최소 비용
                우선순위 큐에 (현재 정점을 거쳐서 갈 수 있는 정점의 최소 비용, 현재 정점을 거쳐서 갈 수 있는 정점)을 넣음
            }
        }
    }
    return costFromStart
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class FindingMinimumCost {

    static int[][] graph;
    static int VERTEX_COUNT;
    static int EDGE_COUNT;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        VERTEX_COUNT = Integer.parseInt(bufferedReader.readLine());
        EDGE_COUNT = Integer.parseInt(bufferedReader.readLine());

        graph = new int[VERTEX_COUNT + 1][VERTEX_COUNT + 1]; // 1부터 시작하는 인접 행렬 구현
        for (int[] row : graph) Arrays.fill(row, -1); // -1로 초기화

        // 간선 정보 입력
        for (int index = 0; index < EDGE_COUNT; index++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            initGraph(edgeInfo); // 간선 정보를 인접 행렬에 저장
        }

        int[] goalInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = goalInfo[0]; // 시작점
        int end = goalInfo[1]; // 도착점
        int[] costFromStart = dijkstra(start); // 시작점에서 각 정점까지의 최소 비용을 구함

        System.out.println(costFromStart[end]); // 구한 최소 비용 배열에서 도착점의 최소 비용을 출력
    }

    private static int[] dijkstra(int start) {
        int[] costFromStart = new int[VERTEX_COUNT + 1];
        Arrays.fill(costFromStart, Integer.MAX_VALUE); // 최소 비용을 구하기 위해 최대값으로 초기화
        costFromStart[start] = 0; // 시작점의 최소 비용은 0

        // 다익스트라 알고리즘에선 다음 정점을 찾을 때 방문 안 한 정점 중 가장 비용이 작은 정점을 찾아야 하므로 우선순위 큐를 사용
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Vertex(start, 0));

        boolean[] visited = new boolean[VERTEX_COUNT + 1]; // 방문 여부를 저장할 배열

        while (!priorityQueue.isEmpty()) {
            Vertex poll = priorityQueue.poll();
            int currentIndex = poll.index;
            int currentCost = poll.cost;

            if (visited[currentIndex]) continue; // 이미 방문한 정점이면 넘어감
            visited[currentIndex] = true; // 방문 안 한 정점이면 방문 처리

            for (int nextIndex = 1; nextIndex <= VERTEX_COUNT; nextIndex++) { // 현재 정점에서 갈 수 있는 모든 정점을 탐색
                int nextCost = graph[currentIndex][nextIndex]; // 현재 정점에서 다음 정점으로 가는 비용
                if (nextCost == -1) continue; // 연결 되지 않은 정점이면 넘어감

                int newCost = currentCost + nextCost; // 현재 정점을 거쳐 다음 정점으로 가는 비용
                if (costFromStart[nextIndex] > newCost) { // 만약 더 작은 비용이라면
                    costFromStart[nextIndex] = newCost; // 갱신
                    priorityQueue.add(new Vertex(nextIndex, newCost)); // 큐에 추가
                }
            }
        }

        return costFromStart;
    }

    private static void initGraph(int[] edgeInfo) {
        int start = edgeInfo[0];
        int end = edgeInfo[1];
        int cost = edgeInfo[2];

        if (graph[start][end] == -1 || graph[start][end] > cost) graph[start][end] = cost;
    }

    static class Vertex implements Comparable<Vertex> {
        int index;
        int cost;

        public Vertex(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        } // 우선순위 큐에서 비용이 작은 순으로 정렬하기 위해 구현
    }
}
