/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/77884
 * Problem Number: 77884
 * Level: 1
 * Algorithm: 수학
 */

/*
 * left부터 right까지의 모든 수 중에서 약수 개수에 따른 수를 반환하는 함수
 * 제곱근이 있는 수는 약수의 개수가 홀수이므로 Math.sqrt 함수를 써서 판별
 */

function solution(left, right) {
    var answer = 0;
    for (let i = left; i <= right; i++) {
        Number.isInteger(Math.sqrt(i)) ? (answer -= i) : (answer += i);
    }
    return answer;
}
