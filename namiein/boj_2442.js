/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 2442
 *  Level: Bronze III
 *  Algorithm: Implementation
 */

const N = require('fs').readFileSync('/dev/stdin').toString().trim();

/* Pseudocode *
    아주 아주 간단한 별 찍기 문제지만 별이 가운데 기준으로 대칭이어야 합니다.
    1.  total : 마지막 줄(N)의 별 total
    2.  num : i 번째 줄의 별 total
    3.  padLength : (total + num) / 2
    4.  repeat()를 사용해서 i 번째 줄의 별을 구한다.
    5.  padStart, padEnd를 적용해서 별의 앞뒤로 빈 값이 출력되도록 한다.
    6.  별을 출력한다.
 */

/** 예시

    *
   ***
  *****
 *******
*********

*/

const TOTAL = 2 * Number(N) - 1;

for (let i = 1; i <= N; i++) {
    const num = 2 * i - 1;
    const padLength = (TOTAL + num) / 2;

    console.log('*'.repeat(num).padStart(padLength, ' ').padEnd(padLength, ' '));
}
