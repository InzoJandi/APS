/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9012
 * Level: Silver IV
 * Algorithm: String
 */

/* Pseudocode *
입력 값의 총 개수 total만큼 순회를 돈다.
입력 값이 올바른 괄호 문자열(VPS)을 포함하지 않을 때까지 반복해서 정규식과 replace를 사용해 VPS를 지워준다.
최종으로 남은 값이 있을 경우 NO를, 남은 값이 없을 경우 YES를 출력한다.
*/

const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

let total = Number(input.shift());

for (let i = 0; i < total; i++) {
  let str = input.shift();
  while (str.includes("()")) {
    str = str.replace(/\(\)/g, "");
  }
  if (str) {
    console.log("NO");
  } else {
    console.log("YES");
  }
}
