/*
 *  PROGRAMMERS SCHOOL
 *  https://school.programmers.co.kr
 *  Problem Number: 12946
 *  Level: 2
 *  Algorithm: Implementation
 */

function solution(n) {
  const result = [];

  const hanoi = (n, from, to) => {
    const mid = 6 - from - to;

    if (n === 1) {
      result.push([from, to]);
    } else {
      hanoi(n - 1, from, mid);
      result.push([from, to]);
      hanoi(n - 1, mid, to);
    }
  };
  hanoi(n, 1, 3);
  return result;
}
