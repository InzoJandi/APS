/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11779
 * Level: GOLD III
 * Algorithm: Graph / Dijkstra
 */

/* Pseudocode *
1. 시작 정점에서의 다익스트라 알고리즘 수행
2. 시작 정점->끝 정점까지의 정보 출력

dijkstra(start) {
    시작 정점에서의 최단 거리를 저장할 배열 생성
    시작 정점에서의 최단 거리를 저장할 배열 초기화
    시작 정점에서의 최단 거리를 저장할 배열에 시작 정점의 최단 거리를 저장
    시작 정점에서의 최단 거리를 저장할 배열을 우선순위 큐에 저장
    우선순위 큐가 빌 때까지 반복
        우선순위 큐에서 최단 거리가 가장 짧은 정점을 꺼냄
        꺼낸 정점에서 갈 수 있는 정점들을 탐색
            꺼낸 정점에서 갈 수 있는 정점이 이미 최단 거리가 저장된 정점이라면 다음 정점으로 넘어감
            꺼낸 정점에서 갈 수 있는 정점이 최단 거리가 저장되지 않은 정점이라면
                꺼낸 정점에서 갈 수 있는 정점의 최단 거리를 갱신
                꺼낸 정점에서 갈 수 있는 정점의 최단 거리를 저장할 배열을 우선순위 큐에 저장
                꺼낸 정점에서 갈 수 있는 정점의 최단 거리를 저장할 배열에 꺼낸 정점을 저장
    시작 정점에서의 최단 거리를 저장할 배열 반환
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindingMinimumCost2 {

    final static int NOT_CONNECTED = -1;
    final static int INF = Integer.MAX_VALUE;
    static int START_NODE;
    static int END_NODE;
    static int VERTEX_COUNT;
    static int EDGE_COUNT;
    static int[][] GRAPH;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    private static void solution() {
        RouteInfo[] routeInfo = dijkstra(START_NODE); // 시작 정점에서의 다익스트라 알고리즘 수행
        RouteInfo startToEnd = routeInfo[END_NODE]; // 시작 정점->끝 정점까지의 최단 경로 정보
        printAnswer(startToEnd); // 정답 출력
    }

    private static void printAnswer(RouteInfo startToEnd) {
        System.out.println(startToEnd.distance); // 최단 경로의 길이
        System.out.println(startToEnd.route.size()); // 최단 경로에 포함된 정점의 개수(거쳐온 정점의 개수)
        startToEnd.route.forEach(node -> System.out.print(node + " ")); // 최단 경로에 포함된 정점들
    }

    private static RouteInfo[] dijkstra(int startNode) { // 다익스트라 알고리즘(핵심 코드)
        RouteInfo[] routeInfos = new RouteInfo[VERTEX_COUNT + 1]; // 시작 정점에서의 최단 경로 정보
        for (int i = 1; i <= VERTEX_COUNT; i++) routeInfos[i] = new RouteInfo(i); // 경로 정보에 시작 노드 추가 및 거리를 무한대로 초기화
        routeInfos[startNode].distance = 0; // 시작 노드 - 시작 노드 거리는 0

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(); // 큐에서 가장 거리가 짧은 노드를 뽑기 위해 우선순위 큐 사용
        priorityQueue.add(new Node(startNode, 0)); // 시작 노드를 우선순위 큐에 추가

        boolean[] visited = new boolean[VERTEX_COUNT + 1]; // 방문 여부를 체크하기 위한 배열

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            int currentNode = current.node; // 현재 노드
            int currentDistance = current.distance; // 현재 노드까지의 거리

            if (visited[currentNode]) continue; // 만약 이미 방문한 노드라면 무시
            visited[currentNode] = true; // 방문 처리

            for (int nextNode = 1; nextNode <= VERTEX_COUNT; nextNode++) { // 현재 노드와 연결된 노드들을 탐색
                int nextDistance = GRAPH[currentNode][nextNode];
                if (nextDistance == NOT_CONNECTED) continue; // 만약 연결되지 않은 노드라면 스킵

                RouteInfo routeInfo = routeInfos[nextNode]; // 다음 노드까지의 최단 경로 정보
                int distanceToNextNode = currentDistance + nextDistance; // 현재 노드를 거쳐 다음 노드로 가는 거리
                if (routeInfo.distance > distanceToNextNode) { // 이미 저장된 다음 노드까지의 최단 경로 정보보다 현재 노드를 거쳐 다음 노드로 가는 거리가 더 짧다면 갱신
                    priorityQueue.add(new Node(nextNode, distanceToNextNode)); // 다음 노드를 우선순위 큐에 추가

                    routeInfo.distance = distanceToNextNode; // 최소 거리로 갱신
                    routeInfo.route.clear(); // 최단 경로를 갱신하므로 기존의 최단 경로를 지움
                    routeInfo.route.addAll(routeInfos[currentNode].route); // 현재 노드까지의 최단 경로를 다음 노드까지의 최단 경로에 복사
                    routeInfo.route.add(nextNode); // 다음 노드를 최단 경로에 추가
                }
            }
        }

        return routeInfos;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        VERTEX_COUNT = Integer.parseInt(bufferedReader.readLine()); // 정점 개수
        EDGE_COUNT = Integer.parseInt(bufferedReader.readLine()); // 간선 개수
        GRAPH = new int[VERTEX_COUNT + 1][VERTEX_COUNT + 1]; // 인접 행렬 그래프 선언(0번째 인덱스는 사용하지 않음)

        for (int i = 0; i < VERTEX_COUNT + 1; i++) Arrays.fill(GRAPH[i], NOT_CONNECTED); // 그래프 초기화
        for (int i = 0; i < EDGE_COUNT; i++) {
            int[] edgeInfo = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = edgeInfo[0]; // 출발 정점
            int end = edgeInfo[1]; // 도착 정점
            int distance = edgeInfo[2]; // 가중치
            if (GRAPH[start][end] == NOT_CONNECTED) GRAPH[start][end] = distance; // 해당 간선을 처음 만나는 경우 초기화
            else GRAPH[start][end] = Math.min(GRAPH[start][end], distance); // 해당 간선이 이미 존재하는 경우 최소값으로 갱신
        }

        int[] target = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        START_NODE = target[0]; // 시작 정점
        END_NODE = target[1]; // 도착 정점
    }

    // 경로 정보를 저장하는 클래스
    static class RouteInfo {
        List<Integer> route = new ArrayList<>(); // 지나온 경로
        int distance = INF; // 시작 정점에서 해당 정점까지의 최단 거리

        public RouteInfo(int node) {
            route.add(node);
        }
    }

    static class Node implements Comparable<Node> {
        int node; // 도착 정점
        int distance; // 거리

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) { // 우선순위 큐에서 거리가 짧은 순으로 정렬
            return this.distance - o.distance;
        }
    }
}
