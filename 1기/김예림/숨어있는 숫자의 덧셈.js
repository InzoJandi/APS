function solution(my_string) {
  let arr = [...my_string];
  let sum = 0;

  arr.forEach((el) => {
    if (!isNaN(el)) {
      sum += Number(el);
    }
  });
  return sum;
}