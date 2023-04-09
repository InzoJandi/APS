/*
 * Programers
 * https://school.programmers.co.kr
 * Problem Number: 92341
 * Level: 2
 * Algorithm: String
 */

/* Pseudocode *
records를 순회하며 history 배열에 차량번호를 숫자로 바꾼 인덱스에
입차/출차 시간을 담을 수 있는 객체({ IN: 0, OUT: 0 })를 저장,
입차 기록일 경우 IN += 시간을 분으로 계산한 number 값,
출차 기록일 경우 OUT += 시간을 분으로 계산한 number 값을 저장한다.

history 배열에서 빈 칸을 필터링한 뒤 map을 돌려 주차 시간을 계산(OUT - IN)한다.
만약 OUT이 IN보다 작을 경우 23:59를 분으로 계산한 1439를 더해 계산한다.
요금표 기준을 참고하여 계산된 요금만 담기게 반환한다.

요금 계산은 다음과 같음
if time <= fees[0] return fees[1];
return fees[1] + Math.ceil((time - fees[0]) / fees[2]) * fees[3];
*/

function solution(fees, records) {
    const history = [];
  
    records.forEach((rcd) => {
      const [time, number, type] = rcd.split(' ');
      const idx = +number;
  
      if (!history[idx]) history[idx] = { IN: 0, OUT: 0 };
      history[idx][type] += timeToMinute(time);
    });
  
    return history
      .filter((v) => !!v)
      .map((log) => {
        if (log.OUT <= log.IN) log.OUT += 1439;
        return timeToFee(log.OUT - log.IN);
      });
  
    function timeToMinute(time) {
      const [h, m] = time.split(':');
      return +h * 60 + +m;
    }
  
    function timeToFee(time) {
      if (time <= fees[0]) return fees[1];
      return fees[1] + Math.ceil((time - fees[0]) / fees[2]) * fees[3];
    }
  }
  