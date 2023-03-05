/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4949
 * Level: Silver IV
 * Algorithm: Data Structures / String / Stack
 */

/* Pseudocode *
주어진 문장을 탐색하여 왼쪽 괄호를 만나면 스택에 넣고
오른쪽 괄호를 만났을 때 스택에서 마지막 것을 꺼내어 짝이 맞는지 비교
짝이 맞으면 탐색을 계속하고, 짝이 맞지 않으면 no로 결과를 내고 종료
문장 탐색이 끝난 뒤 스택에 남아 있는 왼쪽 괄호가 있으면 no로 결과를 내고 종료
문장 탐색이 끝나고 스택이 비워져 있으면 yes로 결과를 내고 종료
*/

const sentences = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\n/);
let answer = '';

const bracket = {
  ')': '(',
  ']': '[',
};
const left = Object.values(bracket);
const right = Object.keys(bracket);

function solution(sentence) {
  const stack = [];
  for (const w of sentence) {
    if (left.includes(w)) {
      stack.push(w);
    }
    if (right.includes(w)) {
      if (stack.pop() !== bracket[w]) {
        answer += 'no\n';
        return;
      }
    }
  }
  if (stack.length) {
    answer += 'no\n';
    return;
  }
  answer += 'yes\n';
}

for (let i = 0; i < sentences.length - 1; i++) {
  solution(sentences[i]);
}
console.log(answer);
