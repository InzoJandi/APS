/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * Problem Number: 42862
 * Level: 1
 * Algorithm: greedy
 */

/*
 * 체육복을 도난 당한 학생을 제외한 학생들의 수를 리턴 = answer라는 변수로 제어
 * 체육복은 바로 전, 뒷 번호의 학생에게만 빌려줄 수 있음
 * reserve에 lost[i]+1 또는 lost[i]-1인 값을 찾기
 * reserve와 lost의 동일한 값이 있으면 다른 학생에게는 빌려줄 수 없음
 * lost 배열이 정렬 되어있지 않을 경우도 있으므로 sort를 먼저 해준다
 */

function solution(n, lost, reserve) {
    let answer = n - lost.length;

    let isLost = lost.filter((l) => !reserve.includes(l));
    let isReserve = reserve.filter((r) => !lost.includes(r));
    answer += lost.length - isLost.length;

    isLost.sort((a, b) => a - b);

    isLost.forEach((l) => {
        if (isReserve.length === 0) {
            return;
        }

        isReserve.includes(l - 1) ? (isReserve = isReserve.filter((r) => r !== l - 1)) : (isReserve = isReserve.filter((r) => r !== l + 1));
        answer++;
    });
    return answer;
}
