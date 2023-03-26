/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 1713
 *  Level: Silver I
 *  Algorithm: 구현, 시뮬레이션
 */

const [N, R, input] = require('fs').readFileSync('/dev/stdin').toString().split('\n');

/* Pseudocode *
    사진틀에 사진이 게재된 최종 후보의 학생 번호를 찾는 문제

    1.  우선 N까지는 추천받은 학생의 번호를 map에 추가한다.
    2.  추천받은 학생이 또 추천을 받은 경우 추천받은 횟수를 증가시킨다.
    3.  새로운 학생이 추천 받았다면 추천받은 횟수가 가장 낮은 학생을 가르키는 번호를 map에서 삭제한다.
    4.  추천 받은 횟수가 가장 적은 학생이 두 명 이상일 경우에는 그러한 학생들 중 게시된 지 가장 오래된 학생의 번호를 삭제한다.
    5.  사진틀에 게시된 학생을 나타내는 번호를 출력한다.
 */

// 추천받은 학생을 나타내는 번호들
const recommendations = input.split(' ').map(Number);

const map = new Map();
for (let i = 0; i < Number(R); i++) {
    // N까지는 추천받은 학생의 번호를 map에 추가한다.
    if (map.size < Number(N)) {
        // 추천받은 학생이 또 추천을 받는다면, 추천받은 횟수를 증가시킨다.
        map.set(recommendations[i], map.get(recommendations[i]) ? map.get(recommendations[i]) + 1 : 1);
    } else if (map.get(recommendations[i])) {
        // 추천받은 학생이 또 추천을 받는다면, 추천받은 횟수를 증가시킨다.
        map.set(recommendations[i], map.get(recommendations[i]) + 1);
    } else {
        // 새로운 학생이 추천 받았다면 추천받은 횟수가 가장 낮은 학생을 가르키는 번호를 map에서 삭제한다.
        const keys = [...map.keys()];
        const smallest = Math.min(...map.values());

        for (let j = 0; j < Number(N); j++) {
            // 가장 낮은 추천받은 횟수 && 가장 오래된 순
            if (map.get(keys[j]) === smallest) {
                // 찾은 값을 삭제한다.
                map.delete(keys[j]);
                // 새로 추천받은 학생의 번호를 추가한다.
                map.set(recommendations[i], 1);
                // 가장 추천받은 횟수가 낮고 오래된 하나의 값만 찾으면 되기 때문에 break
                break;
            }
        }
    }
}

// 최종 후보의 학생 번호를 증가하는 순서대로 출력
console.log([...map.keys()].sort((a, b) => a - b).join(' '));
