function solution(array, commands) {
  let answer = [];

  for (const command of commands) {
    const [start, end, answerIdx] = command;
    answer.push(array.slice(start - 1, end).sort((a, b) => a - b)[answerIdx - 1]);
  }

  return answer;
}
