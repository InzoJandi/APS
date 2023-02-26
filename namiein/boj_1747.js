/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 1747
 *  Level: Silver I
 *  Algorithm: 수학, 브루트포스 알고리즘, 정수론, 소수 판정, 에라토스테네스의 체
 */

const N = require('fs').readFileSync('/dev/stdin').toString();

/* Pseudocode *
    소수이면서 팰린드롬인 수 중에서, 가장 작은 수 구하기
    1.  MAX 값 설정하기
        1-1.  N이 1,000,000일 때 N보다 크거나 같은 소수 : 1,003,001
    2.  소수 구하기 - 에라토스테네스의 체 방법
    3.  소수 && 팰린드롬
        3-1.  출력하고 loop에서 빠져나오기
 */

// N이 1,000,000일 때 N보다 크거나 같은 소수 : 1,003,001
const MAX = 1003001;

// 소수 찾기 - 에라토스테네스의 체
const list = Array(MAX + 1)
    .fill(true)
    .fill(false, 0, 2);

for (let i = 2; i <= MAX; i++) {
    if (list[i]) {
        for (let j = Math.pow(i, 2); j <= MAX; j += i) {
            list[j] = false;
        }
    }
}

// 소수이면서 팰린드롬인 수 중에서, 가장 작은 수 구하기
for (let i = Number(N); i <= MAX; i++) {
    // 소수 && 팰린드롬라면
    if (list[i] && String(i) === [...String(i)].reverse().join('')) {
        // 출력
        console.log(i);
        break;
    }
}
