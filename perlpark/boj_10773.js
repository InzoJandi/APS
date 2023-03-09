/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10773
 * Level: Silver IV
 * Algorithm: Implementation / Data Structures / Stack
 */

/* Pseudocode *
주어진 수가 0보다 크면 스택에 삽입
주어진 수가 0이면 스택에서 마지막 값을 제거
최종적으로 스택에 남은 값을 합산하여 출력
*/

const [_, ...n] = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\n/).map(Number);

let stack = [];
n.forEach((v) => (v > 0 ? stack.push(v) : stack.pop()));

console.log(stack.reduce((p, c) => p + c, 0));
