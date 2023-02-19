import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11403
 * Level: 실버 1
 * Algorithm: Graph
 */

/*
노드를 초기화해주고 정렬한다. 단방향 인접 리스트로 구현
nxn 행렬의 '모든 점'에 대해 bfs 를 수행한다.
결과를 출력한다.
*/

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int NODE = Integer.parseInt(br.readLine());
        LinkedList<Integer>[] nodeList = new LinkedList[NODE+1];

        //단방향 리스트 초기화
        for (int i = 0; i < NODE; i++) {
            String[] s = br.readLine().split(" ");
            nodeList[i+1] = new LinkedList<>();
            for (int j = 0; j < NODE; j++) {
                if(s[j].equals("1")) {
                    nodeList[i+1].add(j+1);
                }
            }
        }

        //정렬
        for (LinkedList<Integer> lists : nodeList) {
            if(lists != null){
                Collections.sort(lists);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= NODE; i++) {
            for (int j = 1; j <= NODE; j++) {
                boolean[] visited = new boolean[NODE+1];
                String canGo = "0";
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while(!queue.isEmpty() && !canGo.equals("1")) {
                    Integer poll = queue.poll();
                    //해당 노드에서 다음 노드가 없는 경우
                    if(nodeList[poll] == null) {
                        break;
                    }

                    for (int k = 0; k < nodeList[poll].size(); k++) {
                        Integer nextNode = nodeList[poll].get(k);
                        //1 -> 1과 같이 자기 순회의 경우 마지막은 이미 방문했을 것이므로 먼저 nextNode에 대해 검사한다.
                        if(nextNode.equals(j)) {
                            canGo = "1";
                            break;
                        }
                        if(visited[nextNode]) {
                            continue;
                        }
                        visited[nextNode] = true;
                        queue.add(nextNode);
                    }
                }

                sb.append(canGo).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
