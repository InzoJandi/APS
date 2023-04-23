/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/132201
 * Problem Number: 132201
 * Level: 1
 * Algorithm: select
 */

SELECT PT_NAME, PT_NO, GEND_CD, AGE, COALESCE(TLNO, 'NONE') AS TLNO
FROM PATIENT
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC;
