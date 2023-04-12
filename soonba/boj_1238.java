
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1238
 * Level: Gold 3
 * Algorithm: dijkstra
 * https://www.acmicpc.net/problem/1238
 */

/*
각 노드(마을)의 가중치를 2차원 배열 초기화
비용 초기화
모든 마을에 대하여 다익스트라 알고리즘 수행
->모두 수행하고 나면, 모든 노드에 대해 최소 비용으로 갱신되어있음을 기대할 수 있음
파티 마을에 가는비용+오는비용의 MAX를 출력
 */
public class Main {

    private static int[][] nodes;
    private static int nodeLength;
    private static boolean[] visit;
    private static int[] distance;
    private static final int MAX_TIME_PER_ROAD = 100;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int[] meta = readLine();
        //마을의 개수
        nodeLength = meta[0];
        //단방향 길의 개수
        int lineNumber = meta[1];
        //파티가 열리는 마을의 index (보정)
        int partyNode = meta[2]-1;
        //a 마을에서 b 마을로 가는 데 가장 많은 비용이 드는 경우
        int maximumCost = (nodeLength -1) * MAX_TIME_PER_ROAD;

        nodes = new int[nodeLength][nodeLength];

        //배열 초기화
        for (int i = 0; i < nodeLength; i++) {
            for (int j = 0; j < nodeLength; j++) {
                if(i == j) {
                    nodes[i][j] = 0;
                    continue;
                }
                nodes[i][j] = maximumCost;
            }
        }

        //비용 초기화
        for (int i = 0; i < lineNumber; i++) {
            int[] nodeInit = readLine();
            //index 보정
            int start = nodeInit[0]-1;
            int end = nodeInit[1]-1;
            int cost = nodeInit[2];
            nodes[start][end] = cost;
        }


        int[][] resultSet = new int[nodeLength][nodeLength];
        //모든 마을에 대해 다익스트라 알고리즘 수행
        for (int i = 0; i < nodeLength; i++) {
            visit = new boolean[nodeLength];
            distance = new int[nodeLength];
            dijkstra(i);
            resultSet[i] = distance;
        }

        int max = 0;
        //result set 에서 가는비용과 오는비용의 최대 값을 출력
        for (int i = 0; i < resultSet.length; i++) {
            int totalCost = resultSet[i][partyNode] + resultSet[partyNode][i];
            max = Math.max(max,totalCost);
        }
        System.out.println(max);
    }

    private static void dijkstra(int start) {
        //현재 마을에서 각 비용을 int[]로 할당
        for (int i = 0; i < nodeLength; i++) {
            distance[i] = nodes[start][i];
        }
        visit[start] = true;

        for (int i = 0; i < nodeLength -2; i++) {
            //현재 배열 중 가장 저렴한 비용의 노드를 방문
            int current = getMinCostIndex();
            visit[current] = true;
            // 현재 방문중인 노드에서 방문 안 한 노드들의 값 갱신
            for (int j = 0; j < nodeLength; j++) {
                if(!visit[j]) {
                    distance[j] = Math.min(distance[j],distance[current]+nodes[current][j]);
                }
            }
        }
    }

    private static int getMinCostIndex() {
        int min = (nodeLength -1) * MAX_TIME_PER_ROAD + 1;
        int index = 0;
        for (int j = 0; j < distance.length; j++) {
            //방문하지 않았고, 비용이 min보다 작으면 갱신
            if(!visit[j] && distance[j] < min) {
                min = distance[j];
                index = j;
            }
        }
        return index;
    }

    private static int[] readLine() throws Exception{
        String s = br.readLine();
        String[] s1 = s.split(" ");
        return Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
    }
}