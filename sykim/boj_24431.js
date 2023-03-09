/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 24431
 * Level: Silver IV
 * Algorithm: String
 */

/* Pseudocode *
new Map()에 문자열을 주어진 접미사 length만큼 자른 값을 key로 하여 value로 해당 접미사를 가진 단어의 개수를 쌓는다.
반복문이 끝나면 쌓인 값을 전개하여, 해당 접미사를 가진 단어의 개수를 2로 나눈 몫을 count에 쌓은 뒤, answer에 push한다.
answer를 join하여 출력한다.
*/

const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

const total = input.shift();
const answer = [];

for (let i = 0; i < total; i++) {
  const [amount, length, suffix] = input.shift().split(" ").map(Number);
  const stringArr = input.shift().split(" ");
  const map = new Map();
  stringArr.forEach((item) => {
    const str = item.slice(length - suffix, length);
    if (map.has(str)) {
      map.set(str, map.get(str) + 1);
    } else {
      map.set(str, 1);
    }
  });

  const arr = [...map];
  let count = 0;
  arr.forEach((item) => {
    const number = item[1];
    count += Math.floor(number / 2);
  });
  answer.push(count);
}

console.log(answer.join("\n"));
