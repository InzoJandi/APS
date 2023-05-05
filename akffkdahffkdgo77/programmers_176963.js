/*
 *  PROGRAMMERS SCHOOL
 *  https://school.programmers.co.kr
 *  Problem Number: 176963
 *  Level: 1
 *  Algorithm: Implementation
 */

/* Pseudocode *
    map을 사용해서 이름 - 추억 점수 조합 생성
    각 배열마다 추억 점수의 합을 구해서 return
*/

function solution(name, yearning, photo) {
    const map = new Map();
    for (let i = 0; i < name.length; i++) {
        map.set(name[i], yearning[i]);
    }

    return photo.map((val) => val.reduce((prev, cur) => prev + (map.get(cur) || 0), 0));
}
