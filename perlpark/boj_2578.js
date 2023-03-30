/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2578
 * Level: Silver IV
 * Algorithm: Implementation / Simulation
 */

/* Pseudocode *
빙고판에서 사회자가 부르는 수와 일치하는 경우 null로 변경
방고 3줄이 나오는 최소 횟수 이상부터 가로, 세로, X자에 빈 칸으로만 이루어진 경우를 카운트
카운트가 3 이상일 때 i+1를 출력하고 종료
*/

const [b1, b2, b3, b4, b5, t1, t2, t3, t4, t5] = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\n/);

const bingo = [b1.split(' '), b2.split(' '), b3.split(' '), b4.split(' '), b5.split(' ')];
const turns = [...t1.split(' '), ...t2.split(' '), ...t3.split(' '), ...t4.split(' '), ...t5.split(' ')];

for (let i = 0; i < turns.length; i++) {
  bingo.forEach((line) =>
    line.forEach((number, idx) => {
      if (number === turns[i]) {
        line[idx] = null;
      }
    })
  );

  if (i > 10) {
    const column = checkColumn();
    const row = checkRow();
    const cross = checkCross();

    if (column + row + cross > 2) {
      console.log(i + 1);
      return;
    }
  }
}

function isEveryNull(v) {
  return v === null;
}

function checkColumn() {
  let count = 0;

  for (let i = 0; i < 5; i++) {
    const testRow = [bingo[0][i], bingo[1][i], bingo[2][i], bingo[3][i], bingo[4][i]];
    if (testRow.every(isEveryNull)) {
      count += 1;
    }
  }

  return count;
}

function checkRow() {
  let count = 0;

  for (let i = 0; i < 5; i++) {
    if (bingo[i].every(isEveryNull)) {
      count += 1;
    }
  }

  return count;
}

function checkCross() {
  let count = 0;

  const testRow1 = [bingo[0][0], bingo[1][1], bingo[2][2], bingo[3][3], bingo[4][4]];
  const testRow2 = [bingo[4][0], bingo[3][1], bingo[2][2], bingo[1][3], bingo[0][4]];

  if (testRow1.every(isEveryNull)) {
    count += 1;
  }
  if (testRow2.every(isEveryNull)) {
    count += 1;
  }

  return count;
}
