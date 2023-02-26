/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1629
 * Level: Silver I
 * Algorithm: Math
 */

/* Pseudocode *
모듈러 연산에 대한 이해가 필요한 문제. 모듈러 연산이란 나머지를 구하는 연산을 의미한다.

모듈러 연산의 곱셈 성질은 아래와 같다.
(A * B) % C = ((A % C) * (B % C)) % C

따라서 B가 짝수일 경우 (A ** B) % C = (((A ** (B / 2)) % C) * ((A ** (B / 2)) % C)) % C,
B가 홀수일 경우 (A ** B) % C = (((A ** (B / 2)) % C) * ((A ** (B / 2)) % C) * (A % C)) % C 와 같으므로,
재귀 함수를 통해 연산량을 줄여 원하는 값을 구할 수 있다.
*/

const [number, amount, divisor] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split(" ")
  .map(BigInt);

const solve = (b) => {
  if (b === BigInt(0)) return BigInt(1);
  if (b === BigInt(1)) return number % divisor;

  const half = solve(b / BigInt(2)) % divisor;

  if (b % BigInt(2)) return (half * half * (number % divisor)) % divisor;
  else return (half * half) % divisor;
};

const answer = solve(amount);

console.log(answer.toString());
