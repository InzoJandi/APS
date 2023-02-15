/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17202
 * Level: Bronze I
 * Algorithm: Implementation / Dynamic Programming / String
 */

/* Pseudocode *
입력 a, b를 테스트를 시작할 수 있게 배열로 만든다.
남은 숫자가 두 자리가 될 때까지 반복하기 위해 while (test.length > 2)
테스트 숫자에서 i번과 i+1번을 더하여 뒷자리만 추출하여 새로운 테스트 숫자가 될 배열에 추가
테스트 숫자가 2가 되면 join하여 출력
*/

const [a, b] = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\n/);

let test = [a[0], b[0], a[1], b[1], a[2], b[2], a[3], b[3], a[4], b[4], a[5], b[5], a[6], b[6], a[7], b[7], a[8], b[8]];
let temp = [];

while (test.length > 2) {
  for (let i = 0; i < test.length - 1; i++) {
    const a = test[i];
    const b = test[i + 1];

    if (!b) break;

    temp.push(String(Number(a) + Number(b)).slice(-1));
  }
  test = temp;
  temp = [];
}
console.log(test.join(''));
