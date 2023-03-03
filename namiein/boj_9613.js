/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 9613
 *  Level: Silver IV
 *  Algorithm: 수학, 정수론, 유클리드 호제법
 */

const input = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : '../../input.txt')
    .toString()
    .trim()
    .split('\n');
const N = input.shift();

/* Pseudocode *
    1.  모든 쌍의 GCD의 합 구하기
    2.  합 출력하기
 */

//  최대 공약수 구하기
const calculateGCD = (min, max) => (!max ? min : calculateGCD(max, min % max));

for (let i = 0; i < N; i++) {
    const nums = input[i].split(' ').map(Number);
    nums.shift();

    let sum = 0;
    // 모든 쌍의 GCD의 합 구하기
    for (let j = 0; j < nums.length; j++) {
        for (let k = j + 1; k < nums.length; k++) {
            sum += calculateGCD(Math.max(nums[j], nums[k]), Math.min(nums[j], nums[k]));
        }
    }
    // 합 출력하기
    console.log(sum);
}
