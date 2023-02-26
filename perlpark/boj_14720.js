/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14720
 * Level: Bronze III
 * Algorithm: Implementation / Greedy
 */

/* Pseudocode *
count % 3 => 0, 1, 2, 0, 1, 2, ...
입력받은 우유 가게 문자열 split(" ")
for문 돌며 if(현재 값 == count % 3) count++;
for문 종료 후 count 출력
*/

const [_, ...shops] = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\s/);

let count = 0;

shops.forEach((_, i) => {
  if (Number(shops[i]) % 3 === count % 3) {
    count = count + 1;
  }
});
