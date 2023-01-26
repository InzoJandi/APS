/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 14405
 *  Level: Bronze I
 *  Algorithm: String
 */

/* Pseudocode *
replace()를 사용해서 input에서 "pi", "ka", "chu" 제거
""을 사용하면 남은 단어끼리 합쳐져서 에러 -> " "로 단어 replace
replace() 후 남은 단어가 있다면 NO 출력 아니면 YES 출력
 */

const input = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : '../../input.txt')
    .toString()
    .trim()
    .split('\n')[0];

const word = ['chu', 'ka', 'pi'];

let answer = input;
word.forEach((val) => (answer = answer.replace(new RegExp(val, 'g'), ' ')));

console.log(answer.trim() ? 'NO' : 'YES');
