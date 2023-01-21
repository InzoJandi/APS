/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/12948
 * Problem Number: 12948
 * Level: 1
 * Algorithm: String
 */

/* 
* 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수
* 문자열에 for문으로 i = length-4 의 true/false를 기준으로 
* true일 경우 [i]번째의 문자열 노출
* false일 경우 *로 대체
*  
* if (i < phone_number.length - 4) {
      answer += '*';
    } else {
      answer += phone_number[i];
    }
*/

function solution(phone_number) {
    let answer = "";

    for (let i = 0; i < phone_number.length; i++) {
        // 해당 문자의 idx 확인하는 조건문
        if (i < phone_number.length - 4) {
            // 뒷 네자리를 제외한 숫자는 *로 표시
            answer += "*";
        } else {
            // 뒷 네자리는 숫자 그대로 표시
            answer += phone_number[i];
        }
    }
    return answer;
}
