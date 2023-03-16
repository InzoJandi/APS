/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15649
 * Level: Silver III
 * Algorithm: Backtracking
 */

/* Pseudocode *
1. m = 선택된 수를 담을 M개의 칸을 가진 배열 선언
2. 사용 여부를 확인할 N개의 칸에 false로 채워진 isUsed 배열 선언
3. 결과 출력용 빈 문자열 result 선언

4. m[0]칸부터 채우도록 func(0) 호출

5. 재귀 함수 func(k)
6. k === M이면 m 배열이 다 찬것이므로 result += m.join('') 하고 종료
7. 배열이 차지 않았으면, 0부터 N-1까지 반복문 실행
8. isUsed[i] 값을 체크, true면 이미 넣은 값이므로 패스
9. false이면 m[k] = i+1, isUsed[i]를 true로 바꿈
10. m 배열의 다음 칸(k+1칸)을 채우기 위해 func(k+1) 해줌
11. k+1칸에 넣을 수 있는 수를 다 넣어봤으면 k칸의 반복문이 재개되기 때문에 isUsed[i] = false 해줌.

과정을 작성해보면 다음과 같음.
편의를 위해 true = 1, false = 0으로 작성 / N = 5, M = 3

func(0)
{depth0 :: isUsed: [0,0,0,0,0]} for (0~4)
i = 0: m = [1]; isUsed = [1,0,0,0,0]; func(1);
    {depth2 :: isUsed: [1,0,0,0,0]} for (0~4)
    i = 0: continue;
    i = 1: m = [1,2]; isUsed = [1,1,0,0,0]; func(2);
        {depth3 :: isUsed: [1,1,0,0,0]} for (0~4)
        i = 0: continue;
        i = 1: continue;
        i = 2: m = [1,2,3]; isUsed = [1,1,1,0,0]; func(3);
            result += 123;
        isUsed = [1,1,0,0,0];
        i = 3: m = [1,2,4]; isUsed = [1,1,0,1,0]; func(3);
            result += 124;
        isUsed = [1,1,0,0,0];
        i = 4: m = [1,2,5]; isUsed = [1,1,0,0,1]; func(3);
            result += 125;
        isUsed = [1,1,0,0,0];
    isUsed = [1,0,0,0,0];
    i = 2: m = [1,3]; isUsed = [1,0,1,0,0]; func(2);
        {depth3 :: isUsed: [1,0,1,0,0]} for (0~4)
        i = 0: continue;
        i = 1: m = [1,3,2]; isUsed = [1,1,1,0,0]; func(3);
            result += 132;
        isUsed = [1,0,1,0,0];
        i = 2: continue;
        i = 3: m = [1,3,4]; isUsed = [1,0,1,1,0]; func(3);
            result += 134;
        isUsed = [1,0,1,0,0];
        i = 4: m = [1,3,5]; isUsed = [1,0,1,0,1]; func(3);
            result += 135;
        isUsed = [1,0,1,0,0];
    isUsed = [1,0,0,0,0];
    i = 3: m = [1,4]; isUsed = [1,0,0,1,0]; func(2);
    ...
*/

const [N, M] = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\s/).map(Number);

let m = [];
const isUsed = Array.from({ length: N }, () => 0);
let result = '';

function func(k) {
  if (k === M) {
    result += m.join(' ') + '\n';
    return;
  }

  for (let i = 0; i < N; i += 1) {
    if (!isUsed[i]) {
      m[k] = i + 1;
      isUsed[i] = 1;
      func(k + 1);
      isUsed[i] = 0;
    }
  }
}

func(0);
console.log(result);
