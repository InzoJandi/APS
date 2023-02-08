/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2503
 * Level: Silver III
 * Algorithm: Brute Force
 */

/* Pseudocode *
세 자리 숫자 중 중복된 수가 없고 0이 포함되면 안 되므로 123부터 987까지의 수만 검증하면 된다.
이 때 Set을 사용하여 수에 중복이 있는지 검증하고, include로 0을 포함하는지 확인한다.
중복된 수가 없고, 0을 포함하지 않는 수라면, 다음을 거쳐 조건에 만족하는 수인지 확인한다.
  1. total만큼 반복하여 각 case에 대해 검증을 진행한다.
  2. case에 주어진 수와 비교할 수의 같은 자리 숫자에 대해 두 숫자가 같다면 scnt에 1을 더한다.
  3. case에 주어진 수와 비교할 수의 같은 자리 숫자에 대해 두 숫자가 같지 않지만 비교할 수가 case의 해당 자리 숫자를 포함하고 있다면 bcnt에 1을 더한다.
  4. 주어진 strike 숫자와 ball 숫자가 구해진 scnt, bcnt와 같다면 passCnt에 1을 더한다.
  5. 반복문이 끝났을 때, total과 passCnt가 같다면 answer에 1을 더한다.
123부터 987까지 검증이 끝난 후, answer을 출력한다.
*/

const [total, ...rest] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

const numbers = rest.map((item) => item.split(" "));

let answer = 0;

for (let i = 123; i < 988; i++) {
  const originArr = [...i.toString()];
  const set = new Set(originArr);
  const newArr = [...set];

  if (newArr.length === 3 && !newArr.includes("0")) checkNumber(i.toString());
}

console.log(answer);

function checkNumber(compare) {
  let passCnt = 0;
  for (let i = 0; i < Number(total); i++) {
    const [number, strike, ball] = numbers[i];
    let scnt = 0;
    let bcnt = 0;
    for (let j = 0; j < 3; j++) {
      if (number[j] === compare[j]) scnt++;
      if (number[j] !== compare[j] && compare.includes(number[j])) bcnt++;
    }
    if (scnt === Number(strike) && bcnt === Number(ball)) passCnt++;
  }

  if (passCnt === Number(total)) answer++;

  return;
}
