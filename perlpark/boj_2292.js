/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2292
 * Level: Bronze II
 * Algorithm: Mathematics
 */

/* Pseudocode *
벌집의 둘레는 1, 7, 19, 27, ... 씩 증가한다.
이 둘레는 +6, +12, +18, ... 6 씩 증가한다.

고로 증가량은 6씩 증가하는 등차수열이고, 둘레는 계차수열임을 알 수 있다.

둘레 a = 1,
증가량 b = 6 로 초기값을 선언
몇 번째 바퀴인지 알 수 있게 count = 1도 선언

입력 받은 수 n이 둘레보다 작으면,
해당 바퀴에 있는 것이기 때문에 바퀴 수(count)를 출력한다.

입력 받은 수 n이 둘레보다 크면,
a+=b 하여 둘레를 증가
증가량은 그 다음 수가 되기 위해 b+=6
바퀴 수도 1 증가 count+=1
*/

const n = +`${require('fs').readFileSync('/dev/stdin')}`.trim();

function solution(n) {
  let a = 1;
  let b = 6;
  let count = 1;

  while (a < n) {
    a += b;
    b += 6;
    count += 1;
  }
  console.log(count);
}

solution(n);
