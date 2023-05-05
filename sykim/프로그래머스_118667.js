/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/118667
 * Problem Number: 118667
 */

/*
  queue1의 원소와 queue2의 원소의 합의 절반(targetSum)이 queue1의 원소의 합(q1Sum)과 같아질 때까지 아래의 과정을 반복한다.
    1-1. q1Sum이 targetSum보다 작다면 queue2[q2Index]를 queue1에 push하고 q1Sum에 더해준다.
    1-2. q1Sum이 targetSum보다 크다면 queue1[q1Index]를 queue2에 push하고 q1Sum에서 빼준다.
    2. answer에 1을 더해준다.
  반복문이 끝나면, answer를 return한다.
  이 때, answer가 queue1의 길이(n)의 4배보다 커질 경우 어떻게해도 두 큐의 합을 같게 만들 수 없으므로 -1을 return한다.
    1. queue1에서 queue2로 queue1의 원소를 모두 보냄 (n)
    2. queue2에서 queue1로 queue2의 원소를 모두 보냄 (n)
    3. queue1에서 queue2로 queue2의 원소를 모두 보냄 (n)
    4. queue2에서 queue1로 queue1의 원소를 모두 보냄 (n)
    -> answer가 4n일 경우 처음 주어진 큐와 같아지므로 합을 같게 만들 수 없음

*/

function solution(queue1, queue2) {
  let answer = 0;

  const qLength = queue1.length;

  let [q1Index, q2Index] = [0, 0];

  let q1Sum = queue1.reduce((pre, curr) => pre + curr, 0);
  const q2Sum = queue2.reduce((pre, curr) => pre + curr, 0);
  const targetSum = (q1Sum + q2Sum) / 2;

  while (q1Sum !== targetSum && answer < qLength * 4) {
    if (q1Sum < targetSum) {
      const q2Item = queue2[q2Index];
      queue1.push(q2Item);
      q1Sum = q1Sum + q2Item;
      q2Index++;
    } else {
      const q1Item = queue1[q1Index];
      queue2.push(queue1[q1Index]);
      q1Sum = q1Sum - q1Item;
      q1Index++;
    }

    answer++;
  }

  if (answer >= qLength * 4) return -1;
  else return answer;
}
