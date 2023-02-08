/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15721
 * Level: Silver V
 * Algorithm: Implementation / Bruteforcing / Simulation
 */

/* Pseudocode *
n = 1에서 시작
0101(0 n번 반복)(1 n번 반복)이 번데기 송의 규칙이다.
노래를 돌면서 찾아야 하는 slogan과 일치하면 count를 증가시킨다.
count가 찾아야하는 T번째와 같아지면 인덱스를 사람 수로 나누어 출력한다.
노래를 다 돌았음에도 count가 찾아야하는 T번째보다 작을 경우 번데기 송을 n+1번 더 부른다.
*/

const [A, T, slogan] = `${require('fs').readFileSync('/dev/stdin')}`
  .trim()
  .split(/\n/);

const rule = (n) => '0101' + '0'.repeat(n + 1) + '1'.repeat(n + 1);
let song = '';

findSloganIndex(1);

function findSloganIndex(n) {
  song += rule(n);

  let count = 0;
  for (const i in song) {
    if (song[i] === slogan) count++;

    if (count == T) {
      console.log(i % A);
      return;
    }
  }

  if (count < T) findSloganIndex(n + 1);
}
