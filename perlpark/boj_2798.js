/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2798
 * Level: Bronze II
 * Algorithm: Bruteforcing
 */

/* Pseudocode *
주어진 카드를 정렬한 다음
[0][1] ... [length-1]
0, 1과 마지막 인덱스를 선택하여 반복문 시작
카드가 겹치면 안되므로 b === a 또는 c === a || c === b일 때 해당 반복문을 건너뜀
a, b, c 인덱스의 값을 합산하여 마지노선 m을 넘지 않으면서, biggest 설정된 값보다 크면 biggest에 다시 대입
max에 c 인덱스를 대입하여 a, b 반복문이 불필요하게 c 인덱스 이상을 탐색하지 않도록 처리
최종적으로 biggest 출력
*/

const [n, m, ...cards] = `${require('fs').readFileSync('/dev/stdin')}`
  .trim()
  .split(/\s/)
  .map((v) => +v);

cards.sort((a, b) => a - b);

function sum(a, b, c) {
  return cards[a] + cards[b] + cards[c];
}

function isAnswer(a, b, c) {
  return sum(a, b, c) <= m;
}

let biggest = 0;
let max = n - 1;

for (let a = 0; a < max - 1; a++) {
  for (let b = 1; b < max; b++) {
    if (b === a) continue;

    for (let c = max; c > -1; c--) {
      if (c === a || c === b) continue;

      if (isAnswer(a, b, c)) {
        if (biggest < sum(a, b, c)) {
          biggest = sum(a, b, c);
          max = c;
        }
        break;
      }
    }
  }
}

console.log(biggest);
