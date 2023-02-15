/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895
 * Problem Number: 42895
 * Level: 3
 * Algorithm: Dynamic Programming(동적계획법)
 */

/*
 * 주어진 숫자 N과 사칙연산만을 사용해서 number를 만들기 위한 최소 N구하기
 * 수식은 괄호와 사칙연산만 가능
 * 최소값이 8보다 크면 -1 반환
 */

function solution(N, number) {
    let answer = -1;
    const numberSet = [];

    if (N === number) {
        answer = 1;
    } else {
        numberSet[1] = new Set().add(N);
        for (let i = 2; i < 9; i++) {
            calcResult(i);

            if (numberSet[i].has(number)) {
                answer = i;
                break;
            }
        }
    }

    function calcResult(count) {
        numberSet[count] = new Set();
        let connectValue = N.toString();

        for (let i = 1; i < count; i++) {
            connectValue += N.toString();
            const [left, right] = [i, count - i];
            for (let leftValue of numberSet[left]) {
                for (let rightValue of numberSet[right]) {
                    numberSet[count].add(leftValue + rightValue);
                    numberSet[count].add(leftValue - rightValue);
                    numberSet[count].add(leftValue * rightValue);
                    if (rightValue !== 0) {
                        numberSet[count].add(Math.floor(leftValue / rightValue));
                    }
                }
            }
        }
        numberSet[count].add(parseInt(connectValue));
    }
    return answer;
}
