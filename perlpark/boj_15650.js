/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15650
 * Level: Silver III
 * Algorithm: Backtracking
 */

/* Pseudocode *
N과 M (1)의 로직과 동일하지만
isUsed를 재귀 함수 스코프에 진입할 때 복제,
상위 스코프에서 기 처리된 isUsed + 현재 스코프에서 처리한 isUsed 상태를 참조하여 중복 값을 제거한다.
스코프를 벗어나기 전 복제해 둔 isUsed로 복구하기 때문에 스코프마다 isUsed 상태를 갖게 된다.
*/

const [N, M] = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\s/).map(Number);

let m = [];
let isUsed = Array.from({ length: N }, () => 0);
let result = '';

function func(k) {
  const isUsedSaved = [...isUsed];
  if (k === M) {
    result += m.join(' ') + '\n';
    return;
  }

  for (let i = 0; i < N; i += 1) {
    if (!isUsed[i]) {
      m[k] = i + 1;
      isUsed[i] = 1;
      func(k + 1);
    }
  }
  isUsed = isUsedSaved;
}

func(0);
console.log(result);
