/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1213
 * Level: Silver III
 * Algorithm: String
 */

/* Pseudocode *
문자열을 오름차순으로 정렬한 후 map을 만들어 문자의 개수를 저장한다.
만든 map을 전개하여 아래 규칙에 따라 answer과 middle을 구한다.
  - count가 홀수일 경우 middle에 저장하고 count가 홀수이면서 3이상일 경우 parseInt(count / 2)만큼 repeat하여 answer에 추가한다.
    이 떄, middle에 이미 저장된 값이 존재한다면 팰린드롬을 만들 수 없으므로, isPalindrome을 false로 바꿔준다.
  - cousnt가 짝수라면, count / 2만큼 repeat하여 answer에 추가한다.
isPalindrome이 true이면 answer + middle + answer.split("").sort().reverse().join("") 을 출력하고,
isPalindrome이 false이면 I'm Sorry Hansoo를 출력한다.
*/

const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("")
  .sort();

const map = new Map();

input.forEach((item) => {
  if (map.has(item)) map.set(item, map.get(item) + 1);
  else map.set(item, 1);
});

let middle = "";
let answer = "";
let isPalindrome = true;

const solve = () => {
  [...map].forEach((item) => {
    const [alphabet, count] = item;
    if (count % 2) {
      if (middle) {
        isPalindrome = false;
      } else {
        middle = alphabet;
        if (count > 1) {
          answer += alphabet.repeat(parseInt(count / 2));
        }
      }
    } else {
      answer += alphabet.repeat(count / 2);
    }
  });

  if (isPalindrome)
    return answer + middle + answer.split("").sort().reverse().join("");
  else return "I'm Sorry Hansoo";
};

console.log(solve());
