/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 14594
 *  Level: Silver IV
 *  Algorithm: 구현, 시뮬레이션
 */

const [N, M, ...input] = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : '../../input.txt')
    .toString()
    .trim()
    .split('\n');

/* Pseudocode *
    남아있는 동아리 방의 개수를 찾는 문제
    
    N은 동아리방의 개수
    M의 빅-종빈빌런의 행동 횟수
    input은 빅-종빈빌런의 행동이 x,y로 주어짐

    빅-종빈빌런 규칙!
        빅-종빈빌런은 x번 방부터 y번 방까지의 벽을 무너뜨린다.
        벽이 허물어진 방은 하나의 방으로 합쳐진다.
        바깥과 연결된 벽 (1번 방의 왼쪽 벽과 N번 방의 오른쪽 벽)은 허물지 않는다.

    1.  배열로 존재하는 동아리 방(N)을 만든다.
    2.  행동 횟수를 나타내는 M만큼 loop를 돌면서 x번 방부터 y번 방까지의 벽을 무너뜨린다.
    3.  벽이 허물어진 방은 false로 표시한다.
    4.  true로 표시되어 있는 방의 개수를 출력한다.
 */

// 동아리 방
const arr = Array.from({ length: N }).fill(true);

// 빌런의 행동 횟수만큼
for (let i = 0; i < M; i++) {
    const [x, y] = input[i].split(' ').map(Number);
    // x번 방부터 y번 방까지의 벽을 무너뜨린다
    for (let j = x; j < y; j++) {
        // 벽이 무너진 방은 false로 표시한다
        arr[j] = false;
    }
}

// true인 방의 개수를 출력한다
console.log(arr.filter((val) => val).length);
