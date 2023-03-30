/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/133024
 * Problem Number: 13024
 * Level: 1
 * Algorithm: select
 */

-- 기본 정렬은 내림차순
-- 총 주문량이 같다면 출하 번호를 기준으로 오름차순 정렬


SELECT FLAVOR
  FROM FIRST_HALF
  ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC