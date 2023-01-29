/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 2775
 *  Level: Bronze I
 *  Algorithm: Math, Implementation, Dynamic Programming
 */

/* Pseudocode *
1.  0층 1호부터 14층 14호까지 각 방에 있는 사람들 수를 계산하고 arr에 push
    0층 i호에는 i명만큼     
    예) 1층 3호방 : 0층 1호 ~ 0층 3호방에 있는 사람들을 합한 수
2.  k-1층 1호부터 n호까지 사람들의 수의 합을 구함
3.  구한 값 출력
 */

const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n').map(Number);
// N 제외
input.shift();

// 0층 1호 ~ 14호까지 미리 준비
const arr = [Array.from({ length: 14 }).map((_, i) => i + 1)];

/** 0층부터 14층까지 사람들 수
1,2,3,4,5,6,7,8,9,10,11,12,13,14
1,3,6,10,15,21,28,36,45,55,66,78,91,105
1,4,10,20,35,56,84,120,165,220,286,364,455,560
1,5,15,35,70,126,210,330,495,715,1001,1365,1820,2380
1,6,21,56,126,252,462,792,1287,2002,3003,4368,6188,8568
1,7,28,84,210,462,924,1716,3003,5005,8008,12376,18564,27132
1,8,36,120,330,792,1716,3432,6435,11440,19448,31824,50388,77520
1,9,45,165,495,1287,3003,6435,12870,24310,43758,75582,125970,203490
1,10,55,220,715,2002,5005,11440,24310,48620,92378,167960,293930,497420
1,11,66,286,1001,3003,8008,19448,43758,92378,184756,352716,646646,1144066
1,12,78,364,1365,4368,12376,31824,75582,167960,352716,705432,1352078,2496144
1,13,91,455,1820,6188,18564,50388,125970,293930,646646,1352078,2704156,5200300
1,14,105,560,2380,8568,27132,77520,203490,497420,1144066,2496144,5200300,10400600
1,15,120,680,3060,11628,38760,116280,319770,817190,1961256,4457400,9657700,20058300
1,16,136,816,3876,15504,54264,170544,490314,1307504,3268760,7726160,17383860,37442160
 */

// 모든 방(14 * 14)에 있는 사람들 수 계산
for (let i = 0; i < 14; i++) {
    const people = [];
    for (let j = 0; j < 14; j++) {
        let sum = 0;
        // i층 0호부터 k호까지
        for (let k = 0; k <= j; k++) {
            sum += arr[i][k];
        }
        people.push(sum);
    }
    arr.push(people);
}

// k-1층 1호 ~ n호까지 사람들의 수의 합 구하기
let answer = '';
for (let i = 0; i < input.length; i += 2) {
    const [k, n] = input.slice(i, i + 2);
    let people = 0;
    for (let j = 1; j <= n; j++) {
        people += arr[k - 1][j - 1];
    }
    answer += `${people}\n`;
}

console.log(answer.trim());
