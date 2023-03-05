/**
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net/
 *  Problem Number: 2841
 *  Level: Silver I
 *  Algorithm: 자료 구조, 스택
 */

const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
input.shift();

/* Pseudocode *
    기타 연주
    어떤 줄의 프렛을 여러 개 누르고 있다면 가장 높은 프렛의 음이 발생한다.
    1. 3번의 5번 프렛을 누르고 있을 때 7번 프렛을 누른 음을 연주하려면, 손을 떼지 않고 7번 프렛을 누르면 된다. (push)
    2. 3번의 5번 프렛을 누르고 있을 때 3번 프렛을 누른 음을 연주하려면, 5번에서 손을 떼고 3번을 눌러야 한다. (pop, push)
    3. 3번의 5번 프렛을 누르고 있을 때 2번의 3번 프렛을 누른다면 손을 떼지 않고 2번의 3번 프렛을 누르면 된다. (친구인 외계인은 손가락을 수십억개 가지고 있다!) (push)
 */

/**
 *  예시
 *  2 8  --> push(8)
 *  --> count++
 *  2 10 --> 10 > 8, push(10)
 *  --> count++
 *  2 12 --> 12 > 10, push(12)
 *  --> count++
 *  2 10 --> 10 < 12, pop()
 *  --> count++
 *  2 5 --> 5 < 10, 5 < 8, pop(), pop(), push(5)
 *  --> count++, count++, count++
 *  --> count: 1 + 1 + 1 + 1 + 1 + 1 + 1 = 7번
 */

// 스택 초기화 작업
// 기타 줄마다 stack을 쌓는다.
// 만약 array가 6개고 n-1로 접근해서 값을 가져오려고 한다면 TypeError 발생
// -> 그래서 7개로 초기화
const stack = [[], [], [], [], [], [], []];

// stack 첫 번째 값
const [firstN, firstP] = input.shift().split(' ').map(Number);
stack[firstN].push(firstP);

// pop, push할 때마다 count++
let count = 1;
input.forEach((val) => {
    const [n, p] = val.split(' ').map(Number);

    // 이전 값이 현재 p값보다 작을 때 push
    if (stack[n][stack[n].length - 1] < p) {
        stack[n].push(p);
        count++;
    } else {
        // 이전 값이 현재 p값보다 크다면 pop
        while (stack[n][stack[n].length - 1] > p) {
            stack[n].pop();
            count++;
        }

        // 만약 이전 값이 현재 p값과 다르다면
        // 현재 p값을 stack에 push
        if (stack[n][stack[n].length - 1] !== p) {
            stack[n].push(p);
            count++;
        }
    }
});

console.log(count);
