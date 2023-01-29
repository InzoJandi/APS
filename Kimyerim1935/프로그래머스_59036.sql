/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/59036
 * Problem Number: 59036
 * Level: 1
 * Algorithm: select
 */

/*
* 아픈 동물의 아이디와 이름을 조회하는 sql문 작성
*/

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'