/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1026
 * Level: Silver IV
 * Algorithm: Greedy, Sorting
 */

/* Pseudocode *
문제에서는 배열 B를 재정렬하지 말라고 했지만, 결국 출력 결과가 정답이면 되기 때문에 A는 오름차순 / B는 내림차순 정렬하여 최솟값 S를 구해주었다.
*/

const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

const total = input.shift();
const [A, B] = input.map((arr) => arr.split(" ").map((item) => +item));

const sortedA = A.sort((a, b) => a - b);
const sortedB = B.sort((a, b) => b - a);

let sum = 0;

for (let i = 0; i < total; i++) {
  sum += sortedA[i] * sortedB[i];
}

console.log(sum);
