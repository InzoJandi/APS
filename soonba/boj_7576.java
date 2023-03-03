import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7576
 * Level: Gold V
 * Algorithm: Graph, BFS
 */

/*
노드를 초기화한다. startNode가 여러개일 수 있으므로, startNode는 리스트로도 추가해준다.
큐가 끝날때까지 BFS를 돌며 하루 카운트 추가를하고, tempQueue에 하루동안 모든 작업을 수행하여 add한 뒤 BFS 큐에 한 번에 추가해준다.queue.addAll();
모든 큐를 수행한 뒤 하나라도 0이 있는지 검사하여 -1 또는 카운트를 출력한다.
* 카운트는 마지막날에 더이상 상할 게 없는 날짜까지 카운트되므로 -1을 해준다.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int C = Integer.parseInt(s[0]);
        int R = Integer.parseInt(s[1]);
        int[][] nodeArr = new int[R + 1][C + 1];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        //처음 1인 노드들
        List<int[]> startNode = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                String target = s1[j];
                if (target.equals("1")) startNode.add(new int[]{i+1, j+1});
                nodeArr[i+1][j+1] = Integer.parseInt(target);
            }
        }

        Queue<int[]> queue = new LinkedList<>(startNode);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Queue<int[]> tempQueue = new LinkedList<>();
            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                int thisR = poll[0];
                int thisC = poll[1];

                for (int j = 0; j < 4; j++) {
                    int nextR = thisR + dx[j];
                    int nextC = thisC + dy[j];

                    if(nextR < 1 || nextC < 1 || nextR > R || nextC > C) continue;
                    if(nodeArr[nextR][nextC] != 0) continue;
                    tempQueue.add(new int[]{nextR,nextC});
                    nodeArr[nextR][nextC] = 1;
                }
            }
            queue.addAll(tempQueue);
        }
        boolean anyZero = false;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (nodeArr[i][j] == 0) {
                    anyZero = true;
                    break;
                }
            }
        }
        if(anyZero) {
            System.out.println(-1);
        } else {
            System.out.println(count-1);
        }
    }
}
