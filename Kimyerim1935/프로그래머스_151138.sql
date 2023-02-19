/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/151138
 * Problem Number: 151138
 * Level: 1
 * Algorithm: String, Date
 */

/*
 * CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 
 * 대여 시작일이 2022년 9월에 속하는 대여 기록에 대하여 대여 기간에 따라 장, 단기로 표시하는 컬럼 추가
 * 30일 이상일 경우, 장기 대여. 30일 미만일 경우 단기 대여
 * 대여 기록 ID를 기준으로 내림차순 정렬하기
 */
-- 



SELECT HISTORY_ID, CAR_ID, 
	   DATE_FORMAT (START_DATE, "%Y-%m-%d") AS START_DATE, 
	   DATE_FORMAT (END_DATE, "%Y-%m-%d") AS END_DATE,
CASE WHEN DATEDIFF(END_DATE, START_DATE) < 29 then '단기 대여' 
            ELSE '장기 대여' 
            END AS  RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE LIKE '2022-09-%'
ORDER BY HISTORY_ID DESC;