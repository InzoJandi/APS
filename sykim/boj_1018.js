/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1018
 * Level: Silver IV
 * Algorithm: Brute Force
 */

/* Pseudocode *
주어진 보드의 (0,0) 지점을 기준으로 8*8 보드로 잘라 완전한 체스판을 이루는 체스판 두 개와 비교한다.
이 때 각각의 체스판과 다른 문자의 개수를 서로 비교해 작은 수를 answer에 저장한다.
이 과정을 (m-8,n-8) 지점을 기준으로 하였을 때까지 반복한다.
단, (0,0) 이후의 반복에서는 각각의 체스판과 다른 문자의 개수와 이전에 저장된 answer까지 비교하여 가장 작은 수를 answer에 저장한다.
answer를 출력한다.
*/

const [numbers, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

const [n, m] = numbers.split(" ");

let answer = undefined;

const white = [
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
];
const black = [
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
  "BWBWBWBW",
  "WBWBWBWB",
];

for (let i = 0; i <= Number(n) - 8; i++) {
  for (let j = 0; j <= Number(m) - 8; j++) {
    const blackCount = compareBlackStart(i, j);
    const whiteCount = compareWhiteStart(i, j);

    const min = Math.min(blackCount, whiteCount);

    if (answer === undefined) answer = min;
    else answer = Math.min(min, answer);
  }
}

console.log(answer);

function compareBlackStart(x, y) {
  let cnt = 0;
  for (let k = 0; k < 8; k++) {
    for (let l = 0; l < 8; l++) {
      if (black[k][l] !== input[x + k][y + l]) cnt++;
    }
  }
  return cnt;
}

function compareWhiteStart(x, y) {
  let cnt = 0;
  for (let k = 0; k < 8; k++) {
    for (let l = 0; l < 8; l++) {
      if (white[k][l] !== input[x + k][y + l]) cnt++;
    }
  }
  return cnt;
}
