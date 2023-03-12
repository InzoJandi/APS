/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 15650
 *  Level: Silver III
 *  Algorithm: 백트래킹
 */

const [N, M] = require('fs').readFileSync('/dev/stdin').toString().trim().split(' ').map(Number);

/* Pseudocode *
    graph: 수열 정보를 가지고 있는 배열
    visited : 방문 정보를 가지고 있는 배열
    start : for loop의 시작 index (앞에서 이미 찾은 조합은 다시 뽑지 않도록)
    from : dfs 함수의 인자

    *** 중요 ***
    1 2 3 4, 1 2 4 3, 2 1 3 4 
    -> 모두 오름차순 정렬하면 1 2 3 4
    -> 이미 찾은 조합!

    1. 아직 방문하지 않은 경우
        1-1. visited의 값을 true로 변경
        1-2. graph에 값 저장
        1-3. dfs(i, from+1) 호출
    2. dfs 함수가 종료된 다음
        2-1. graph에 저장한 값 pop()
        2-2. visited의 값을 false로 변경 (다음 i가 체크할 수 있도록)
    * graph.pop()을 하지 않는다면 수열 완성쪽 코드에서
        -> M까지만 answer로 push되도록 처리해줘야 함
        -> answer.push(graph.slice(0, M).join(' ')) 
 */

// 수열 정보
// M이 3이라면 [0, 0, 0]
let graph = Array(M).fill(0);
// 방문 정보
// N이 4라면 [false, false, false, false]
let visited = Array(N).fill(false);
// 마지막에 join으로 처리하기 위해서
const answer = [];

function dfs(start, from) {
    // * 수열 완성
    if (from === M) {
        answer.push(graph.join(' '));
    }

    // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    // -> [2, 2], [1, 1] -> X
    // 고른 수열은 오름차순
    //  -> 앞에서 이미 찾은 조합은 다시 뽑지 않도록
    for (let i = start; i <= N; i++) {
        if (!visited[i]) {
            // 수열에 저장
            graph[from] = i;
            // 방문 처리
            visited[i] = true;
            dfs(i, from + 1);
            // 저장한 수 제거
            graph.pop();
            // 방문 처리 제거
            visited[i] = false;
        }
    }
}

// dfs(for loop index의 시작 값, 현재 수열의 원소 개수)
dfs(1, 0);

// 답 출력
console.log(answer.join('\n'));
