/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 20291
 *  Level: Silver III
 *  Algorithm: String
 */

/* Pseudocode *
new Map()을 사용해서 ext별 total 계산
hash를 오름차순으로 정렬한 후 join을 사용해서 출력
replace()를 사용해서 ,를 ' '으로 변경
 */

const input = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : '../../input.txt')
    .toString()
    .trim()
    .split('\n');
input.shift();

const hash = new Map();
input.forEach((val) => {
    const ext = val.split('.')[1];
    hash.set(ext, hash.get(ext) ? hash.get(ext) + 1 : 1);
});

const answer = [...hash]
    .sort((a, b) => a[0].localeCompare(b[0]))
    .join('\n')
    .replace(/,/g, ' ');
console.log(answer);
