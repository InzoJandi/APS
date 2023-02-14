/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2748
 * Level: Bronze I
 * Algorithm: Mathematics / Dynamic Programming
 */

/* Pseudocode *
a=0, b=1에서 시작하여 a=b, b=c(c=a+b) 반복해서 계산
마지막으로 더한 수(n번째 더한 수)를 출력
만약 n이 0이면 b를 반환하는 fib 함수로 0을 출력할 수 없으므로 바로 0을 출력
*/

function fib(n) {
    let a = BigInt(0);
    let b = BigInt(1);
    for (let i = 2; i <= n; i++) {
      let c = a + b;
      a = b;
      b = c;
    }
    return b;
  }
  
  const n = +`${require('fs').readFileSync('/dev/stdin')}`.trim();
  console.log(n > 0 ? String(fib(n)) : 0);
  
