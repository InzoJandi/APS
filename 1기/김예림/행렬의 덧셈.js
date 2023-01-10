function solution(arr1, arr2) {
  return arr1.map((a, i) => a.map((b, j) => b + arr2[i][j]));
}

function solution(arr1, arr2) {
  const answer = [];
  arr1.forEach((arr, i) => answer.push(arr.map((v, j) => v + arr2[i][j])));
  return answer;
}
