/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2675
 * Level: Bronze II
 * Algorithm: String / Implementation
 */

/* Pseudocode *
문자열을 줄 단위로 split하여 배열로 받음
배열[0]을 n으로 설정, [1]부터 [n]까지 순회
배열[i]의 문자열을 공백(' ')으로 split
문자열[0]을 반복 횟수로 사용
문자열[1]로 새 배열을 만들면서 각 단어에 repeat 적용
만들어진 새 배열을 빈 문자열('')로 join하여 result에 줄내림('\n')과 함께 저장
반복문이 종료되면 console.log(result);
*/

const input = require('fs').readFileSync('/dev/stdin').toString().trim().split(/\n/);
let result = '';

for (let i = 1; i <= input[0]; i++) {
    const [r, words] = input[i].split(' ');
    result += Array.from(words, w => w.repeat(r)).join('') + '\n';
}
console.log(result);