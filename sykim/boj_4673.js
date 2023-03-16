/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 4673
 * Level: Silver V
 * Algorithm: Math, Brute Force
 */

/* Pseudocode *
1~10000까지의 수가 든 배열을 만든다.
해당 배열을 reduce 함수와 Map을 사용해 key는 각 숫자, value는 false인 Map으로 변환한다.
1~10000까지 순회를 돌며 d(n)을 구해 해당 값을 Map이 key로 가지고 있을 경우 value를 true로 바꿔준다.
순회가 끝난 후, Map을 배열로 변환하여 value를 false로 가지고 있는 key를 꺼내 출력한다.
*/

const numbers = Array(10000)
  .fill()
  .map((item, index) => index + 1);

const arrMap = numbers.reduce((map, item) => {
  map.set(item, false);
  return map;
}, new Map());

for (let i = 1; i <= 10000; i++) {
  const numberArr = [...i.toString()];
  const sum = numberArr.reduce((pre, curr) => {
    return Number(pre) + Number(curr);
  }, i);
  if (arrMap.has(sum)) {
    arrMap.set(sum, true);
  }
}

const filteredArr = [...arrMap]
  .filter((arr) => arr[1] === false)
  .map((item) => item[0]);

console.log(filteredArr.join("\n"));
