/*
 *  PROGRAMMERS SCHOOL
 *  https://school.programmers.co.kr
 *  Problem Number: 118667
 *  Level: 2
 *  Algorithm: Implementation
 */

function solution(queue1, queue2) {
  let count = 0;
  const sum = (arr) => arr.reduce((acc, cur) => acc + cur, 0);

  let sum1 = sum(queue1),
    sum2 = sum(queue2);
  let left = 0,
    right = queue1.length;

  const mid = (sum1 + sum2) / 2;
  const queue = [...queue1, ...queue2];

  const maxCount = (queue.length + 1) * 2 + 1;

  // 두 큐의 합이 같지 않으면 while문 실행
  while (sum1 !== mid) {
    // sum1이 sum2 보다 크면 left 값을 빼고 left index +1
    if (sum1 > mid) {
      sum1 -= queue[left++];
    // 반대의 경우에는 right 값을 더하고 rigth index +1
    } else {
      sum1 += queue[right++];
    }

    count++;
    // 모든 경우의 수에도 합을 같게 만들 수 없다면 -1 출력
    if (count >= maxCount) return -1;
  }
  return count;
}
