/**
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net/
 *  Problem Number: 10816
 *  Level: Silver IV
 *  Algorithm: 자료 구조, 정렬, 이분 탐색, 해시를 사용한 집합과 맵
 */

const [N, A, M, B] = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : '../../input.txt')
    .toString()
    .trim()
    .split('\n');

/* Pseudocode *
    A Set - 각 카드별 total 구하기
    B Set - 각 카드가 A Set에 존재하는지 확인
    --> 만약 카드가 있다면 해당 카드의 total을 answer에 push
    --> 카드가 없다면 0을 push
    마지막에 답 출력
*/

// 상근이가 가지고 있는 숫자 카드에 적혀있는 정수
const A_SET = A.split(' ').map(Number);
// 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 하는 정수
const B_SET = B.split(' ').map(Number);

// 카드별로 몇 개씩 있는지
const map = new Map();
for (let i = 0; i < Number(N); i++) {
    map.set(A_SET[i], map.get(A_SET[i]) ? map.get(A_SET[i]) + 1 : 1);
}

// 만약 B 세트에 A 카드가 존재한다면
// A 카드의 total을 answer에 push
const answer = [];
for (let i = 0; i < Number(M); i++) {
    if (map.get(B_SET[i])) {
        answer.push(map.get(B_SET[i]));
    } else {
        answer.push(0);
    }
}

// 답 출력
console.log(answer.join(' '));
