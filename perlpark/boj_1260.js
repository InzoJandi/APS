/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1260
 * Level: Silver II
 * Algorithm: Graph Theory / Graph Traversal / Breadth-first Search / Depth-first Search
 */

/* Pseudocode *
1. 입력의 조건과 정점의 정보를 받는다.
2. 그래프를 그린다. (g)
2-1. 정점의 개수 NxN 사이즈의 false로 채운 배열을 만든다.
2-2. 정점의 정보에 따라 간선이 놓인 정점 쌍에 true로 놓는다.
2-2-1. 배열의 인덱스는 0부터 시작하므로 정점의 정보에 -1을 해준다.
3. bfs
3-1. 큐에 시작 정점을 넣고 해당 정점을 확인했다는 표시로 visited로 설정한다. (vis 배열에 push 함)
3-1-1. 배열의 인덱스는 0부터 시작하므로 시작 정점의 번호에 -1을 해준다.
3-2. 큐가 빌 때까지 반복하는 반복문을 선언한다.
3-3. 반복문에서 큐의 첫 번째 정점을 꺼낸다. (cur) 해당 정점을 결과에 포함 (result에 추가)
3-3-1. 정점 번호에 -1을 했으므로 결과에 저장할 떈 다시 +1을 해준다.
3-4. 해당 정점의 간선 정보를 보기 위해 그래프 g[cur]을 순회하는 반복문을 선언한다.
3-5. 다른 정점(i)이 이미 확인한 적 있다면 패스
3-6. 다른 정점(i)이 현재 정점(cur)과 연결되어있지 않아도 패스
3-7. 다른 정점(i)이 현재 정점(cur)과 연결되어 있고 확인한 적 없다면 큐에 넣고, 확인했다는 표시로 visited로 설정한다. (vis 배열에 push 함)
3-8. 최종적으로 큐가 다 비면 result를 출력하도록 한다.
4. dfs
4-1. dfs는 함수를 재귀하여, 방문 표시와 result에 담을 때 연결되어 있는 정점들로 순서를 우선한다는 차이만 있따....
예를 들면 bfs는 cur -> cur과 연결된 다른 정점들을 우선 vis,
        dfs는 cur -> cur과 연결된 다른 정점 1개(*) vis -> 그 다른 정점과 연결된 다른 정점 1개 vis -> 연결된 정점이 없으면 이전 정점으로 돌아감
        이런 차이가 있다...

*) 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문한다는 조건인 경우, 연결된 정점 중 번호가 낮은 것이 선택된다.

5. dfs -> bfs 순으로 호출한다.
*/

const [condition, ...m] = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\n/);

const [N, M, V] = condition.split(/\s/);
const newArray = (f) => new Array(+N).fill(f);

const g = [];
const start = +V - 1;

// 그래프 생성
for (let i = 0; i < +N; i++) {
  g[i] = newArray(false);
}
for (let i = 0; i < +M; i++) {
  const [start, end] = m[i].split(' ').map((v) => v - 1);
  g[start][end] = true;
  g[end][start] = true;
}

// BFS
function bfs() {
  const q = [];
  const vis = newArray(false);
  let result = '';

  q.push(start);
  vis[start] = true;

  while (q.length > 0) {
    const cur = q.shift();
    result += cur + 1 + ' ';

    for (let i = 0; i < +N; i++) {
      if (vis[i]) continue;
      if (!g[cur][i]) continue;

      q.push(i);
      vis[i] = true;
    }
  }
  console.log(result);
}

// DFS
function dfs() {
  const vis = newArray(false);
  let result = '';

  function search(cur) {
    vis[cur] = true;
    result += cur + 1 + ' ';

    for (let i = 0; i < +N; i++) {
      if (vis[i]) continue;
      if (!g[cur][i]) continue;

      search(i);
    }
  }
  search(start);
  console.log(result);
}

dfs();
bfs();
