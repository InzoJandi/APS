/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2606
 * Level: Silver III
 * Algorithm: Graph Traversal
 */

/* Pseudocode *
각 컴퓨터가 어떤 컴퓨터와 연결되어있는지 입력값을 통해 graph 배열로 만든다.
1번 컴퓨터부터 시작해서, 1번 컴퓨터와 연결되어있는 컴퓨터들을 돌면서 연결된 컴퓨터를 visited 배열에 담는다.
remains에 연결된 컴퓨터가 더 이상 남아있지 않을 때까지 반복한 후 visited를 반환한다.
1번 컴퓨터에 의해 감염된 컴퓨터의 수를 구하는 것이므로, 반환된 visited.length - 1을 출력한다.
*/

const [total, edge, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

const graph = Array.from({ length: Number(total) + 1 }, () => []);

for (let i = 0; i < Number(edge); i++) {
  const [curr, next] = input[i].split(" ").map(Number);

  graph[curr].push(next);
  graph[next].push(curr);
}

const DFS = () => {
  const visited = [];
  const remains = [1];

  while (remains.length !== 0) {
    const current = remains.pop();

    if (!visited.includes(current)) {
      visited.push(current);
      remains.push(...graph[current]);
    }
  }

  return visited;
};

graph.forEach((v) => v.sort((a, b) => b - a));
const dfs = DFS();

console.log(dfs.length - 1);
