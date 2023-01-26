/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11720
 * Level: Bronze IV
 * Algorithm: String
 */

/* Pseudocode *
문자열을 줄 기준으로 split하여 배열(inputData)로 받음.
받은 데이터 중 연산해야하는 문자열을 전개하여 배열(dataArr)로 변환.
전개한 배열을 리듀서 함수를 이용하여 합을 구한 후 return 후 출력.
*/

const fs = require("fs");
const inputData = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const solve = (inputData) => {
  const dataSting = inputData[1];
  const dataArr = [...dataSting];

  return dataArr.reduce((prev, curr) => {
    return parseInt(prev) + parseInt(curr);
  });
};

console.log(solve(inputData));
