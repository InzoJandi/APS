/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1260
 * Level: SILVER II
 * Algorithm: DFS, BFS
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*

주어진 값에서 계속 사용되는 데이터는 static 으로 초기화한다.

nodeList
- 라인 정보를 가지고있는 배열로, 방향이 없으므로 한 라인에 2 노드에 모두 추가해준다.
- 같은 차수(뎁스?) 에서 우선순위를 부여하기 위해 정렬한다.

visitDFS
- dfs static 메서드 내에서 파라미터로 계속 넣지 않아도 됨
visitBFS
- 안해도 되지만 통일하고자 굳이 static..

dfs
재귀호출 방식으로 구현
시작 노드로 출발하여 방문 여부를 체크한 후 방문하지 않은 다음 노드에 대해 dfs 호출

bfs
큐를 이용한 while문으로 구현
시작 노드로 출발하여 큐가 빌 때까지 while문을 돈다. 큐에서 노드가 poll이 되면 해당 노드가 가진 다음 노드 중 방문하지 않은 노드를 넣는다.
 */
public class Main {
    static LinkedList<Integer>[] nodeList;
    static boolean[] visitBFS;
    static boolean[] visitDFS;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int node = Integer.parseInt(s[0]);
        int lineInfo = Integer.parseInt(s[1]);
        int startNode = Integer.parseInt(s[2]);

        //노드 초기화
        nodeList = new LinkedList[node + 1];
        for (int i = 0; i < nodeList.length; i++) {
            nodeList[i] = new LinkedList<>();
        }
        for (int i = 0; i < lineInfo; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            //방향이 상관 없으므로 a, b 두 노드 모두 등록
            nodeList[a].add(b);
            nodeList[b].add(a);
        }

        // 작은 수부터 탐색하기 위해 정렬
        for (LinkedList<Integer> integers : nodeList) {
            Collections.sort(integers);
        }


        //dfs
        StringBuilder dfsResult = new StringBuilder();
        visitDFS = new boolean[node + 1];
        dfs(startNode,dfsResult);


        //bfs
        visitBFS = new boolean[node + 1];
        Queue<Integer> bfsQueue = new LinkedList<>();

        //첫 노드를 queue에 넣고 while문 시작
        visitBFS[startNode] = true;
        bfsQueue.add(startNode);

        StringBuilder bfsResult = new StringBuilder();
        while (!bfsQueue.isEmpty()) {

            Integer poll = bfsQueue.poll();
            bfsResult.append(poll).append(" ");

            //poll() 을 해주면서 해당 node의 모든 노드를 담는다. 이 때 이미 방문했다면 패스
            for (int i = 0; i < nodeList[poll].size(); i++) {
                Integer nextNode = nodeList[poll].get(i);
                if (!visitBFS[nextNode]) {
                    bfsQueue.add(nextNode);
                    visitBFS[nextNode] = true;
                }
            }
        }

        System.out.println(dfsResult);
        System.out.println(bfsResult);

    }

    static void dfs(int node, StringBuilder result) {
        //이미 방문한 노드라면 패스
        if(visitDFS[node]) {
            return;
        }

        //방문
        StringBuilder addedResult = result.append(node).append(" ");
        visitDFS[node] = true;
        for (int i = 0; i < nodeList[node].size(); i++) {
            //다음 노드 방문을 위한 재귀 호출
            Integer nextNode = nodeList[node].get(i);
            dfs(nextNode,addedResult);
        }
    }

}
