/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 2748
 *  Level: Bronze I
 *  Algorithm: Math, DP
 */

const N = require('fs').readFileSync('/dev/stdin').toString().trim();

/* Pseudocode *
    0.  메모이제이션 (Memoization) 기법 사용
    1.  리스트 초기화
    3.  1 또는 2일 때 1을 return
        3-1.  n은 90보다 작거나 같은 수
        3-2.  BigInt 처리를 해줘야 한다 (숫자뒤에 n을 붙이면 됨)
    4.  계산했었던 문제라면 그대로 return
    5.  아직 계산하지 않은 문제
        5-1.  피보나치 결과 반환
 */

// 한 번 계산된 결과를 메모이제이션 (Memoization)하기 위한 리스트 초기화
let arr = [];

// Memoization 기법
function fibo(x) {
    // 1 또는 2일 때 1 return
    if (x === 1n || x === 2n) {
        return 1n;
    }

    // arr[x] !== 0
    if (arr[x]) {
        return arr[x];
    }

    // 아직 계산하지 않은 문제라면
    arr[x] = fibo(x - 1n) + fibo(x - 2n);

    // 피보나치 결과 반환
    return arr[x];
}

// n은 90보다 작거나 같은 수이기 때문에 BigInt처리를 해줘야 한다
// 출력할 때 toString()을 적용

// 예시
// 2880067194370816120n -> 2880067194370816120
console.log(fibo(BigInt(N)).toString());
