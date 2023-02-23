/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/49189
 * Problem Number: 49189
 * Level: 3
 * Algorithm: Graph
 */

/*
[
  [...연결된 노드번호],  //0번째(= 노드1)
  [...연결된 노드번호],  //1번째(= 노드2) 
  [...연결된 노드번호],  //2번째(= 노드3) 
  ...
]

이런식으로 연결관계를 나타낸 다음, 기본적으로 BFS는 현재 deps에 해당하는 노드들을 먼저 다 탐색한 뒤
다음 deps로 넘어가기 때문에 현재 deps값을 추적하여 가장 멀리 있는 노드를 탐색할 수 있다. 해당 deps 값 추적은 동일하게 
visited 변수를 선언하여 해당 변수에 방문의 표시로 자신의 deps 값을 넣어주는 방식으로 구현했다.
위의 BFS를 모두 돌고나면 visited 배열에는 각 deps가 담겨있을 것이다. 각각의 값은 노드 1번으로부터 떨어져있는 거리를 의미한다.
우리가 필요한 것은 가장 멀리 떨어진 노드이므로 먼저 해당 visited 배열에서 최댓값을 찾은 뒤,
그 최댓값이 배열에 모두 몇개 있는지를 찾아 반환해주면 될 것 이다.
*/

function solution(n, edge) {
    const connects = new Array(n).fill().map((_) => []);
    for (const e of edge) {
        connects[e[0] - 1].push(e[1] - 1);
        connects[e[1] - 1].push(e[0] - 1);
    }

    const visited = [1];
    const queue = [0];
    while (queue.length) {
        const cur = queue.shift();

        for (const next of connects[cur]) {
            if (!visited[next]) {
                visited[next] = visited[cur] + 1;
                queue.push(next);
            }
        }
    }

    const max = Math.max(...visited);

    return visited.filter((el) => el === max).length;
}
