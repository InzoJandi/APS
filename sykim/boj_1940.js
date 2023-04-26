/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1940
 * Level: Silver IV
 * Algorithm: Two Pointer
 */

/* Pseudocode *
1. 같은 수를 더할 수는 없기 때문에 startIndex는 0부터, endIndex는 1부터 시작해 입력값들의 합계를 구한다.
2. 합계가 sum과 같다면 answer에 1을 더해준다.
3-1. endIndex가 total - 1이 아니라면 endIndex를 +1 한 후 다시 합계를 구한다.
3-2. endIndex가 total - 1이라면 startIndex를 +1하고 endIndex를 startIndex + 1로 초기화한다.
4. startIndex와 endIndex가 모두 total - 1이 될 떄까지 위 과정을 반복한 후 answer를 출력한다.
*/

const [inputTotal, inputSum, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

const total = +inputTotal;
const sum = +inputSum;
const numbers = input.split(" ").map(Number);

let answer = 0;

let startIndex = 0;
let endIndex = 1;

while (startIndex < total - 1 || endIndex < total - 1) {
  if (startIndex === endIndex) ++endIndex;

  const itemSum = numbers[startIndex] + numbers[endIndex];

  if (itemSum === sum) ++answer;

  if (endIndex === total - 1) {
    ++startIndex;
    endIndex = startIndex + 1;
  } else {
    ++endIndex;
  }
}

console.log(answer);
