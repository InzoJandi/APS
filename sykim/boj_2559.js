/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2559
 * Level: Silver III
 * Algorithm: Prefix Sum, Two Pointer
 */

/* Pseudocode *
  startIndex의 초기값을 0, endIndex의 초기값을 K-1로 설정한 후, endIndex가 N과 같아질 때까지 아래 과정을 반복한다.
    1. temperatures의 startIndex번째부터 endIndex번째까지의 요소의 합을 구한다.
    2-1. startIndex가 0일 경우 초기 합을 지정해야하기 때문에 tempSum을 max에 넣어준다.
    2-2. 이외의 경우 max와 tempSum을 비교해 큰 수를 max에 넣어준다.
  반복문이 끝나면 max를 출력한다.
*/

const [numbers, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

const [total, length] = numbers.split(" ").map(Number);
const temperatures = input.split(" ").map(Number);

let max = 0;
let [startIndex, endIndex] = [0, length - 1];

while (endIndex < total) {
  let tempSum = 0;
  for (let i = startIndex; i <= endIndex; i++) {
    const item = temperatures[i];
    tempSum += item;
  }

  if (startIndex === 0) {
    max = tempSum;
  } else {
    max = Math.max(max, tempSum);
  }

  startIndex++;
  endIndex++;
}

console.log(max);
