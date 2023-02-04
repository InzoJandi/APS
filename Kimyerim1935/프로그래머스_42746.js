/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * Problem Number: 42746
 * Level: 1
 * Algorithm: 정렬
 */

/*
 * numbers를 문자열로 변환
 * 정수를 이어 붙여 만들 수 있는 가장 큰 수를 리턴 해야 함
 * 정렬한 다음, join으로 합쳐서 리턴
 * 0일 경우, 그대로 리턴 0이 아닐 경우 answer 리턴
 */

function solution(numbers) {
    const answer = numbers
        .map((c) => c + "")
        .sort((a, b) => b + a - (a + b))
        .join("");

    return answer[0] === "0" ? "0" : answer;
}
