/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4949
 * Level: Silver IV
 * Algorithm: Stack
 */

/* Pseudocode *
각 문장을 탐색하여 '(' 나 '[' 가 나오면 temp에 push하고 ')' 나 ']' 가 나오면 temp에서 pop하여 짝이 맞는지 확인한다.
짝이 맞지 않고, 해당 문장에서 answer에 push한 적이 없다면 'no'를 넣어준다.
반복문이 끝난 후, 해당 문장에서 answer에 push한 적이 없을 때 temp의 length가 0이 아니면 짝이 맞지 않는 괄호가 있다는 뜻이므로 'no'를
temp의 length가 0이라면 'yes'를 answer에 넣어준 후, join하여 출력한다.
*/

const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

const total = input.length - 1;
const answer = [];

for (let i = 0; i < total; i++) {
  const stringArr = input[i].split("");
  const temp = [];
  let isNo = false;
  stringArr.forEach((item) => {
    if (item === "(" || item === "[") {
      temp.push(item);
    }
    if (item === ")" || item === "]") {
      const pop = temp.pop();
      if ((item === ")" && pop !== "(") || (item === "]" && pop !== "[")) {
        if (!isNo) {
          answer.push("no");
          isNo = true;
        }
      }
    }
  });
  if (!isNo) {
    if (temp.length) {
      answer.push("no");
    } else {
      answer.push("yes");
    }
  }
}

console.log(answer.join("\n"));
