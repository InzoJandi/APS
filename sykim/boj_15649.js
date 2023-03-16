/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 15649
 * Level: Silver III
 * Algorithm: Backtracking
 */

/* Pseudocode *
1부터 N까지를 순회하며 길이 M만큼의 배열을 만든다.
이 때, 이미 배열에 넣어진 숫자들을 체크하기 위헤 visited 배열을 사용하여 해당 순번의 숫자가 false일 경우에만 배열에 넣어준다.
길이가 M이 될 때까지 재귀하여 실행한 후 만들어진 배열들을 answer에 담아 출력한다.
*/

const [n, m] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const solution = (n, m) => {
  const array = new Array(m).fill(0);
  const visited = new Array(n).fill(false);

  const answer = [];

  const dfs = (k) => {
    if (k === m) {
      const temp = [];
      for (let i = 0; i < m; i++) {
        temp.push(array[i]);
      }
      return answer.push(temp.join(" "));
    }

    for (let i = 1; i <= n; i++) {
      if (!visited[i]) {
        array[k] = i;
        visited[i] = true;
        dfs(k + 1);
        visited[i] = false;
      }
    }
  };

  dfs(0);
  return answer.join("\n");
};

console.log(solution(n, m));
