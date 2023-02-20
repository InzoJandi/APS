/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 2606
 *  Level: Silver III
 *  Algorithm: 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색
 */

const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const computers = Number(input.shift()); // 컴퓨터 total
const pairs = Number(input.shift()); // 연결되어 있는 컴퓨터 pair total

/* Pseudocode *
 *  1. graph : 각 노드가 연결된 정보
 *  2. visited : 각 노드가 방문된 정보
 *  3. dfs 메소드 정의
 *  4. dfs 메소드 호출 (1번 컴퓨터부터 시작)
 *  5. 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수 출력
 */

// graph : 각 노드가 연결된 정보
// computers + 1 -> index와 수를 맞춰주기 위해서
let graph = [...Array(computers + 1)].map(() => []);
/** 예시
 *  graph default값
 *  [
 *      [], [], [], [],
 *      [], [], [], []
 *  ]
 */

// visited : 각 노드가 방문된 정보
let visited = Array.from(computers + 1).fill(false);

/** 예시
 *  연결된 정보를 리스트로
 *  [
 *      [],
 *      [ 2, 5 ],
 *      [ 1, 3, 5 ],
 *      [ 2 ],
 *      [ 7 ],
 *      [ 1, 2, 6 ],
 *      [ 5 ],
 *      [ 4 ]
 *  ]
 */
input.forEach((i) => {
    let [from, to] = i.split(' ').map(Number);
    graph[from].push(to);
    graph[to].push(from);
});

// 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
let count = 0;

// DFS 메소드 정의
function dfs(from) {
    // 현재 노드를 방문 처리
    visited[from] = true;
    // 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for (let to of graph[from]) {
        if (!visited[to]) {
            count++;
            dfs(to);
        }
    }
}

dfs(1);
console.log(count);
