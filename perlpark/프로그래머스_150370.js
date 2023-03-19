/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 150370
 * Level: 2
 * Algorithm: -
 */

/* Pseudocode *
유효기간과 약관 수집일의 월을 더하여 12가 넘으면 연도를 증가
구해진 파기일자와 오늘 날짜를 비교하여 answer에 담음
*/

function termsToObj(arr) {
    let obj = {};
    for (let i = 0; i < arr.length; i++) {
      const [key, value] = arr[i].split(' ');
      obj[key] = Number(value);
    }
    return obj;
  }
  
  function solution(today, terms, privacies) {
    const todayDate = new Date(today);
    const termsObj = termsToObj(terms);
    const answer = [];
  
    privacies.forEach((item, idx) => {
      const [fullDate, type] = item.split(' ');
      let [year, month, date] = fullDate.split('.').map(Number);
  
      month += termsObj[type];
  
      while (month > 12) {
        year += 1;
        month -= 12;
      }
  
      // 한 달이 28일이므로 date가 1이면 month-=1, date=29로 보정 (Date 타입으로 바꿀 때 28일로 바뀜)
      if (date === 1) {
        date = 29;
        month -= 1;
  
        if (month < 1) {
          month = 12;
          year -= 1;
        }
      }
  
      const expired = new Date(`${year}.${month}.${date}`);
  
      if (todayDate.getTime() >= expired.getTime()) {
        answer.push(idx + 1);
      }
    });
  
    return answer;
  }
  