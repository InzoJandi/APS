/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/82612
 * Problem Number: 82612
 * Level: 1
 * Algorithm: unknown
 */

/*
 * 원래 이용료는 price이지만, 거듭할수록 횟수 * price로 변경
 * count만큼 반복하여 내가 가지고 있는 금액에서 모자란 차액 구하기
 * 빈 배열을 하나 만들어서 지불하게 되는 요금 값 추가
 * reduce 함수로 모든 값을 더한 뒤, money에서 계산
 */

function solution(price, money, count) {
    let answer = 0;
    let use = [];

    for (let i = 1; i <= count; i++) {
        use.push(price * i);
    }
    answer = use.reduce((a, b) => a + b);

    if (answer - money > 0) {
        return answer - money;
    } else return 0;
}
