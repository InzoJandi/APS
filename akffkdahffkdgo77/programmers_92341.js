/*
 *  PROGRAMMERS SCHOOL
 *  https://school.programmers.co.kr
 *  Problem Number: 92341
 *  Level: 2
 *  Algorithm: Implementation
 */

/* Pseudocode *
    1. 차량 입고 - 출고 기록을 가지고 자동차별 누적 시간 계산
    2. 누적 시간으로 자동차별 주차 요금 계산
        2 - 1. 입고 기록만 있고 출고 기록이 없는 경우 -> 출고 시간을 23:59분으로 해서 주차 요금을 계산
*/

function convertToMinutes(time) {
    const [hour, minute] = time.split(':').map(Number);
    return hour * 60 + minute;
}

function calculate(totalTime, fees) {
    let totalPrice = fees[1];

    if (totalTime > fees[0]) {
        totalPrice += Math.ceil((totalTime - fees[0]) / fees[2]) * fees[3];
    }
    return totalPrice;
}

function solution(fees, records) {
    const timeList = {};
    records.forEach((val) => {
        const [time, num, status] = val.split(' ');
        if (!timeList[num]) {
            timeList[num] = { start: null, total: null };
        }

        if (status === 'IN') {
            timeList[num].start = convertToMinutes(time);
        } else {
            timeList[num].total += convertToMinutes(time) - timeList[num].start;
            timeList[num].start = null;
        }
    });

    const priceList = [];
    Object.keys(timeList)
        .sort((a, b) => a - b)
        .forEach((key) => {
            if (timeList[key].start !== null) {
                timeList[key].total += 23 * 60 + 59 - timeList[key].start;
                timeList[key].start = null;
            }

            priceList.push(calculate(timeList[key].total, fees));
        });

    return priceList;
}
