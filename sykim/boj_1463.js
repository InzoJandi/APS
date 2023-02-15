/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1463
 * Level: Silver III
 * Algorithm: Dynamic Programing
 */

/* Pseudocode *
DP[i]는 DP[i-1]에서 1을 더한 값과 같다.
단, i를 2로 나누었을 때나, i를 3으로 나누었을 때에 횟수가 더 적어지는 경우가 생기기 때문에,
DP[i-1]+1과 DP[i/2]+1과 DP[i/3]+1의 값을 비교하여 가장 작은 값을 DP[i]에 넣어준다.
total만큼의 반복문을 실행한 후, DP[total]을 출력한다.
*/

const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim();

const total = Number(input);
const DP = new Array(total + 1).fill(0);

for (let i = 2; i <= total; i++) {
  DP[i] = DP[i - 1] + 1;

  if (i % 2 === 0) DP[i] = Math.min(DP[i], DP[i / 2] + 1);
  if (i % 3 === 0) DP[i] = Math.min(DP[i], DP[i / 3] + 1);
}

console.log(DP[total]);
