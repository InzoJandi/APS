/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/151136
 * Problem Number: 151136
 * Level: 1
 * Algorithm: Select
 */

/*
 * CAR_RENTAL_COMPANY_CAR 테이블에서 
 * 자동차 종류가 suv인 자동차들의 평균 일일 대여 요금을 출력
 * 소수 첫 번째 자리에서 반올림, AVERAGE_FEE로 컬럼명 지정
 */
-- 

SELECT floor(avg(DAILY_FEE)) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR 
where car_type = 'SUV'