/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1920
 * Level: Silver IV
 * Algorithm: Binary Search
 */

/* Pseudocode *
1. new Set 사용
-> 기준이 되는 배열 A를 Set으로 만들어 배열 B를 순회하면서 B의 요소들이 Set에 포함되는지 has를 이용해서 찾아 결과를 출력한다.
2. 이분 탐색 사용
-> 배열 A를 오름차순 정렬한 후 배열 B를 순회하면서 탐색 범위를 절반씩 버려가며 포함 여부를 찾아 결과를 출력한다. 

Set을 사용하면 코드가 굉장히 간편해지지만 메모리를 조금 더 쓰는 것 같다.
*/

const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");
const [N, A, M, B] = input.map((item) =>
  item.split(" ").map((number) => Number(number))
);

// Set 사용 풀이
const set = new Set(A);
const answer = B.map((b) => (set.has(b) ? 1 : 0));
console.log(answer.join("\n"));

// 이분 탐색 사용 풀이
const sortedA = A.sort((a, b) => a - b);

const answerArr = B.map((b) => {
  let startIdx = 0;
  let endIdx = A.length - 1;
  let isExist = false;
  while (startIdx <= endIdx) {
    let mid = Math.floor((startIdx + endIdx) / 2);
    if (b > sortedA[mid]) {
      startIdx = mid + 1;
    } else if (b < sortedA[mid]) {
      endIdx = mid - 1;
    } else {
      isExist = true;
      break;
    }
  }
  return isExist ? 1 : 0;
});

console.log(answerArr.join("\n"));
