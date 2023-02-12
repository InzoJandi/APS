/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1010
 * Level: Silver V
 * Algorithm: Dynamic Programing, Combination
 */

/* Pseudocode *
N에서 M을 연결하는 n개의 다리를 겹치지 않게 놓는 방법은 N에서 n개를 뽑고, M에서 n개를 뽑는 방법과 같다.
일단 뽑아두면, 겹치지 않게 연결할 수 있는 방법은 한가지씩 밖에 존재하지 않는다.
따라서 nCn * mCn이 문제의 해답인데, nCn은 1이므로 mCn의 값을 구하면 된다.
mCn은 m부터 1씩 빼가며 n개를 곱한 후 n!로 나눈 값이다.
n, m이 30이 될 수도 있으므로, 숫자 선언을 BigInt로 해준 뒤 계산했다.
*/

const [total, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

const answer = [];

for (let i = 0; i < Number(total); i++) {
  const [n, m] = input[i].split(" ");
  let numerator = BigInt(1); // 분자
  let denominator = BigInt(1); // 분모
  for (let j = 0; j < Number(n); j++) {
    numerator = numerator * (BigInt(m) - BigInt(j));
    denominator = denominator * (BigInt(j) + BigInt(1));
  }
  answer.push(numerator / denominator);
}

console.log(answer.join("\n"));
