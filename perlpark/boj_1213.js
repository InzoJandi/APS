/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1213
 * Level: Silver III
 * Algorithm: Implementation / String / Greedy
 */

/* Pseudocode *
가운데 들어갈 문자열은 1개이거나 없어야 하고
그외 문자열은 최소 2개 이상, 짝수 개여야 함

'A'
'AA'
'AAB'
'AABB'
'AAABB' or 'AABBC'
...

입력받은 문자열을 split하여 sort
sort된 문자열의 [0], [1]번을 비교하여 같으면
그 두 개 문자열을 정답 배열의 앞에서 빈칸, 뒤에서 빈칸에 push
그리고 나머지 문자열로 반복해서 처리

[0], [1]번을 비교하여 같지 않으면
그 문자열은 홀수 개이므로 middle 값으로 설정,
middle 값이 이미 있는데 홀수 개 문자열이 또 발견되면 팰린드롬이 될 수 없으므로 실패 처리

반복문이 종료되면 middle 값을 정답 배열의 빈 칸(가운데)에 넣고 join하여 출력
*/



let s = `${require('fs').readFileSync('/dev/stdin')}`.trim().split('').sort();
let middle = '';
const answer = Array(s.length);

function pushAnswer(a, b) {
  const firstBlankIdx = answer.findIndex((v) => !v);
  const lastBlankIdx = answer.length - answer.findIndex((v) => !v) - 1;

  answer[firstBlankIdx] = a;
  if (b) {
    answer[lastBlankIdx] = b;
  }
}

let i = 0;
while (i < s.length) {
  const [a, b, ...rest] = s;
  if (a === b) {
    pushAnswer(a, b);
    s = rest;
    continue;
  }
  if (middle) {
    console.log("I'm Sorry Hansoo");
    return;
  }
  middle = s.shift();
}

pushAnswer(middle);
console.log(answer.join(''));
