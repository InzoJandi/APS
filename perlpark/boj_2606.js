/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2606
 * Level: Silver III
 * Algorithm: Graph Theory / Graph Traversal / Breadth-first Search / Depth-first Search
 */

/* Pseudocode *
DFS와 BFS에 썼던 BFS 로직에 확인 순서를 알 필요는 없으니 result를 제거하고
방문 여부를 체크하는 vis 배열에서 시작점을 제외한 길이를 출력
filter(true인 것만).length - 1
*/

const [N, M, ...m] = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\n/);

const newArray = (f) => new Array(+N).fill(f);

const g = [];
const start = 0;

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

  q.push(start);
  vis[start] = true;

  while (q.length > 0) {
    const cur = q.shift();

    for (let i = 0; i < +N; i++) {
      if (vis[i]) continue;
      if (!g[cur][i]) continue;

      q.push(i);
      vis[i] = true;
    }
  }
  console.log(vis.filter((v) => v).length - 1);
}

bfs();
