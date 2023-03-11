import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1389
 * Level: Silver 1
 * Algorithm: Graph
 */

/*
입력값을 파싱하고 리스트배열을 만들어 노드끼리 이어준다.
모든 노드리스트들을 오름차순 정렬해준다.
BFS를 돌며 가장 작은 케빈베이컨을 출력한다. (주석참조)
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int USER = read();
        int NODE = read();

        LinkedList<Integer>[] nodeList = new LinkedList[USER + 1];
        for (int i = 0; i < NODE; i++) {
            int f1 = read();
            int f2 = read();
            if (nodeList[f1] == null) nodeList[f1] = new LinkedList<>();
            if (nodeList[f2] == null) nodeList[f2] = new LinkedList<>();
            nodeList[f1].add(f2);
            nodeList[f2].add(f1);
        }

        for (int i = 1; i < nodeList.length; i++) {
            Collections.sort(nodeList[i]);
        }

        int min_kevin_bacon_number = Integer.MAX_VALUE;
        int min_kevin_bacon_user = 0;
        //유저 i에서
        for (int i = 1; i <= USER; i++) {
            int kevin_bacon_number = 0;
            //유저 j까지의 케빈베이컨 수를 BFS로 계산
            for (int j = 1; j <= USER; j++) {
                int[] nodeValue = new int[USER + 1];
                if (i == j) continue;
                Queue<Integer> queue = new LinkedList<>();
                boolean[] visit = new boolean[USER + 1];
                visit[i] = true;
                queue.add(i);
                nodeValue[i] = 0;
                int aNodeValue = 0;
                while (!queue.isEmpty()) {
                    Integer thisNode = queue.poll();
                    for (int k = 0; k < nodeList[thisNode].size(); k++) {
                        Integer nextNode = nodeList[thisNode].get(k);
                        if (visit[nextNode]) continue;
                        nodeValue[nextNode] = nodeValue[thisNode] + 1;
                        if (nextNode == j) {
                            aNodeValue = nodeValue[nextNode];
                            queue.clear();
                            break;
                        }
                        visit[nextNode] = true;
                        queue.add(nextNode);
                    }
                }
                kevin_bacon_number += aNodeValue;
            }
            // 가장 작은 수와 유저를 갱신
            if (min_kevin_bacon_number > kevin_bacon_number) {
                min_kevin_bacon_user = i;
            }
            min_kevin_bacon_number = Math.min(min_kevin_bacon_number, kevin_bacon_number);
        }

        System.out.println(min_kevin_bacon_user);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
