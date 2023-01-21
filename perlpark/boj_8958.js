/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 8958
 * Level: Bronze II
 * Algorithm: String / Implementation
 */

/* Pseudocode *
문자열을 줄 단위로 split하여 배열로 받음
배열[0]을 n으로 설정, [1]부터 [n]까지 순회
배열[i]에 담긴 문자열을 순회
문자열[i]가 O라면 calculation = calculation + 1; sum += calculation;
문자열[i]가 X라면 calculation = 0;
문자열 순회가 종료되면 result += sum + '\n';
배열 순회가 종료되면 console.log(result);
*/

const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split(/\n/);
let result = '';

for (let i = 1; i <= input[0]; i++) {
  let sum = 0;
  let calculation = 0;

  for (const string of input[i]) {
    if (string === 'O') {
      calculation = calculation + 1;
      sum += calculation;
    }
    if (string === 'X') {
      calculation = 0;
    }
  }
  result += sum + '\n';
}
console.log(result);
