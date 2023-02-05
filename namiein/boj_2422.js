/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 2422
 *  Level: Silver V
 *  Algorithm: Brute Force Algorithm
 */

const [first, ...input] = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : '../../input.txt')
    .toString()
    .trim()
    .split('\n');

const [N, M] = first.split(' ').map(Number);

/* Pseudocode *
1. 섞어먹으면 안 되는 조합을 나타내는 array 생성
    1-1. 섞어먹으면 안 되는 경우 : true, 나머지 : false
    1-2. [1, 3] & [3, 1] -> 모두 섞어먹으면 안 되는 조합. 따라서 두 가지 케이스 모두 true로 변경
2. 1 ~ N까지 loop
    2-1. i, j, k는 1 이상인 값
    2-2. notGoodCombination을 접근할 때는 i, j, k에서 1을 빼고 (index는 0부터 시작해야 함)
    2-3. 섞어먹으면 안 되는 조합이라면 continue를 사용해서 skip
    2-4 [i, j, k] 조합이 완성된다면 sum++ 
3. sum 출력
 */

// JS는 미리 array를 준비해야 함
const notGoodCombination = Array.from({ length: N }).map(() => Array.from({ length: N }).fill(false));

/** notGoodCombination 예시
 *  [
 *      [ false, true, true, false, false ],
 *      [ true, false, false, false, false ],
 *      [ true, false, false, true, false ],
 *      [ false, false, true, false, false ],
 *      [ false, false, false, false, false ]
 *  ]
 */

// 만약 섞어먹으면 안 되는 조합이라면 true, 아니면 false
for (let i = 0; i < M; i++) {
    const [first, second] = input[i].split(' ').map(Number);
    // 1, 3 & 3, 1 모두 섰어먹으면 안 되는 조합
    notGoodCombination[first - 1][second - 1] = true;
    notGoodCombination[second - 1][first - 1] = true;
}

let sum = 0;
for (let i = 1; i <= N; i++) {
    for (let j = i + 1; j <= N; j++) {
        // i, j가 1 이상 -> i-1, j-1해서 0부터 시작하도록
        // 만약 섞어먹으면 안 되는 조합이라면 skip
        if (notGoodCombination[i - 1][j - 1]) {
            continue;
        }

        for (let k = j + 1; k <= N; k++) {
            // 만약 섞어먹으면 안 되는 조합이라면 skip
            if (notGoodCombination[k - 1][j - 1] || notGoodCombination[i - 1][k - 1]) {
                continue;
            }
            // 그 외
            sum++;
        }
    }
}

// 가능한 방법 합계 출력
console.log(sum);
