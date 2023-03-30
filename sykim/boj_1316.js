/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1316
 * Level: Silver V
 * Algorithm: String, Simulation
 */

/* Pseudocode *
각 단어를 알파벳(alphabet) 별로 아래 규칙에 따라 for문을 돈다.
  1. alphabet이 alphabets 배열에 없다면 alphabet을 alphabets에 push 한다.
  2. alphabet이 alphabets 배열에 있으면서 alphabets의 마지막 요소와 같다면 alphabet을 alphabets에 push 한다.
alphabet이 alphabets 배열에 있는데 마지막 요소와 같지 않다면 그룹 단어가 될 수 없으므로, for문을 다 돈 후에 alphabets와 strings의 length가 달라지게 된다.
alphabets와 strings의 length가 같은 경우에만 answer에 1을 더해주고, answer를 출력한다.
*/

const [total, ...rest] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

let answer = 0;

for (let i = 0; i < +total; i++) {
  const alphabets = [];
  const strings = [...rest[i]];

  strings.forEach((alphabet) => {
    if (!alphabets.includes(alphabet)) alphabets.push(alphabet);
    else {
      if (alphabets[alphabets.length - 1] === alphabet)
        alphabets.push(alphabet);
    }
  });

  if (alphabets.length === strings.length) answer += 1;
}

console.log(answer);
