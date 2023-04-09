/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341?language=javascript
 * Problem Number: 92341
 */

/*
주어진 records를 차랭 번호 별로 in, out을 모아 temp 객체를 생성한다.
temp 객체의 keys(차량 번호)를 번호가 작은 순서대로 정렬하여 keys 배열을 선언한다.
keys 배열을 돌며, 차량이 들어온 시간과 나간 시간의 차이를 구해 fees의 요금 정보를 통해 차량 별 정산 요금을 산정한다.
산정된 요금을 answer에 push한 후 반환한다.
*/

function solution(fees, records) {
  const [defaultTime, defaultFee, unitTime, unitFee] = fees;

  let answer = [];

  const temp = {};

  records.forEach((item) => {
    const [time, number, status] = item.split(" ");
    if (status === "IN" && !temp[number]) {
      temp[number] = [time];
    } else {
      const timeArr = temp[number];
      timeArr.push(time);
      temp[number] = timeArr;
    }
  });

  const keys = Object.keys(temp).sort((a, b) => +a - +b);

  keys.forEach((key) => {
    const record = temp[key];
    let fee = defaultFee;
    let totalTime = 0;

    for (let i = 0; i < Math.ceil(record.length / 2); i++) {
      const inTime = new Date(`2023/04/09 ${record[i * 2]}:00`);
      const outTime = record[i * 2 + 1]
        ? new Date(`2023/04/09 ${record[i * 2 + 1]}:00`)
        : new Date(`2023/04/09 23:59:00`);
      const diffSec = outTime.getTime() - inTime.getTime();
      const diffMin = diffSec / (60 * 1000);
      totalTime += diffMin;
    }

    if (totalTime - defaultTime > 0) {
      const additionalFee =
        Math.ceil((totalTime - defaultTime) / unitTime) * unitFee;
      fee += additionalFee;
    }

    answer.push(fee);
  });

  return answer;
}
