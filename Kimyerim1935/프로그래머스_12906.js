/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * Problem Number: 12906
 * Level: 1
 * Algorithm: Stack
 */

/*
 * filter 함수를 사용하여 중복된 숫자를 제거하고 남은 수 반환
 */

function solution(arr) {
    return arr.filter((el, index) => el != arr[index + 1]);
}
