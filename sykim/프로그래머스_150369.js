/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/150369
 * Problem Number: 150369
 */

/*
  먼 곳을 적은 횟수로 갈 수 있도록 먼 곳의 배달물부터 수거, 배달하는 것이 중요하다.
*/

function solution(cap, n, deliveries, pickups) {
  let answer = 0;

  while (deliveries.length || pickups.length) {
    // deliveries와 pickups의 마지막에 있는 0 제거
    while (deliveries.length && !deliveries[deliveries.length - 1]) {
      deliveries.pop();
    }
    while (pickups.length && !pickups[pickups.length - 1]) {
      pickups.pop();
    }

    answer += Math.max(deliveries.length, pickups.length) * 2;

    let delivered = 0;
    let pickuped = 0;

    while (deliveries.length) {
      const item = deliveries.pop();

      if (cap > delivered + item) {
        delivered += item;
      } else {
        deliveries.push(delivered + item - cap);
        break;
      }
    }

    while (pickups.length) {
      const item = pickups.pop();

      if (cap >= pickuped + item) {
        pickuped += item;
      } else {
        pickups.push(pickuped + item - cap);
        break;
      }
    }
  }

  return answer;
}
