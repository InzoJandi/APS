/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/131112
 * Problem Number: 131112
 * Level: 1
 * Algorithm: select
 */

/*
* 강원도에 위치한 식품공장의 공장 ID, 공장 이름, 주소를 조회하는 SQL문을 작성
*/

SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원도%'
ORDER BY FACTORY_ID ASC;