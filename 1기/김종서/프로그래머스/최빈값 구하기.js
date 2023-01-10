function solution(array) {
  const arr = new Array(Math.max(...array) + 1).fill(0);

  for (const el of array) {
    arr[el]++;
  }
  
  const max = Math.max(...arr);
  
  return arr.filter((el) => el === max).length > 1 ? -1 : arr.indexOf(max);
}
