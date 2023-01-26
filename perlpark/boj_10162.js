/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 10162
 * Level: Bronze IV
 * Algorithm: Mathematics /	Implementation / Greedy
 */

/* Pseudocode *
a 버튼은 300초, b 버튼은 60초, c 버튼은 10초로 설정
주어진 초를 10으로 나눈 나머지 값이 있는 경우에 -1을 출력하고 종료
10으로 나누어 떨어지면 코드를 계속 진행
주어진 초보다 버튼에 설정된 초가 더 큰 경우, 해당 버튼을 누를 수 없기 때문에 "0"과 공백(" ")을 정답 텍스트에 추가
누를 수 있는 경우(버튼에 설정된 초가 작은 경우),
[주어진 초/버튼에 설정된 초]로 나누고 다음 버튼도 누를 수 있게 소수점은 버린 뒤 count로 설정
정답 텍스트에 count 값과 공백(" ")을 추가하고
주어진 초에서 [버튼에 설정된 초 * count] 만큼 뺀다.
a, b, c 버튼 모두 해당 로직을 타게하면 정답 완성
*/

let t = `${require('fs').readFileSync('/dev/stdin')}`.trim();

const [a, b, c] = [300, 60, 10];
let answer = '';

if (t % c > 0) {
  console.log(-1);
  return;
}

function press(second) {
  if (t < second) {
    answer += '0 ';
  } else {
    const count = Math.floor(t / second);
    answer += `${count} `;
    t -= second * count;
  }
}

press(a);
press(b);
press(c);

console.log(answer);
