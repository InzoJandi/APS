/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11047
 * Level: Silver IV
 * Algorithm: Greedy
 */

/* Pseudocode *
입력 값에서 데이터의 총 개수 total(N)과 주어진 값 price(K)를 구한다.
남은 입력 값인 동전의 가치를 가치가 큰 순서로 정렬한다.
N만큼 순회를 돌면서, K를 가치가 큰 동전으로 나눈 몫을 구한다.
이 때, 몫이 0이 아닐 경우에만 사용된 동전의 수인 amount에 몫을 더해주고, price에서 동전의 가치 * 몫 만큼의 금액을 빼는 과정을 반복한다.
price가 0이 되었을 경우 break로 순회를 빠져나온다.
사용된 동전의 총 개수인 amount를 출력한다.
*/

const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

let [total, price] = input
  .shift()
  .split(" ")
  .map((item) => Number(item));
const sortedArr = input.map((item) => Number(item)).sort((a, b) => b - a);

let amount = 0;
for (let i = 0; i < total; i++) {
  const quotient = parseInt(price / sortedArr[i]);
  if (quotient !== 0) {
    amount += quotient;
    price -= quotient * sortedArr[i];
  }
  if (price === 0) break;
}

console.log(amount);
