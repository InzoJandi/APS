/*
 *  PROGRAMMERS SCHOOL
 *  https://school.programmers.co.kr
 *  Problem Number: 118667
 *  Level: 2
 *  Algorithm: Implementation
 */

/* Pseudocode *
    투 포인터 사용
    각 큐의 합이 목표 값이 될 때까지 포인터를 움직이며 횟수 증가
    목표 값이 될 수 없다면 -1 반환
*/

function solution(queue1, queue2) {
    let sum1 = queue1.reduce((prev, cur) => prev + cur, 0);
    const sum2 = queue2.reduce((prev, cur) => prev + cur, 0);

    // 각 큐의 원소 합을 같게 만들 수 없는 케이스
    if ((sum1 + sum2) % 2 !== 0) {
        return -1;
    }

    const queue = [...queue1, ...queue2]; // 두 큐를 합친 리스트
    const target = (sum1 + sum2) / 2; // 목표 값

    // TWO POINTER : 두 개 또는 그 이상의 포인터를 두고 값들을 비교하여 문제를 해결하는 알고리즘
    // 배열 안에 여러 값들을 비교할 때
    let startPointer = 0;
    let endPointer = queue1.length;
    const limit = queue1.length * 3;

    // count: 작업 횟수
    for (let count = 0; count < limit; count++) {
        // 각 큐의 합 === 목표 값
        if (sum1 === target) {
            return count;
        }

        // 합이 타켓 값보다 크다면
        if (sum1 > target) {
            // startPointer를 한 칸 올린다
            sum1 -= queue[startPointer++];
        } else {
            // endPointer를 한 칸 올린다
            sum1 += queue[endPointer++];
        }
    }

    // 그 외는 -1로 반환
    return -1;
}
