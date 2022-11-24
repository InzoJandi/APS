function solution(num) {
  let count = 0;

  function handleNum(num) {
    if (count > 499) return -1;
    if (num === 1) return count;
    count++;
    num % 2 === 0 ? handleNum(num / 2) : handleNum(num * 3 + 1);
  }

  handleNum(num);

  return count > 499 ? -1 : count;
}
