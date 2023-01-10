function solution(nums) {
  const num = Math.floor(nums.length / 2);

  const filtered = nums.filter((el, idx) => nums.indexOf(el) === idx).length;

  if (filtered > num) {
    return num;
  } else {
    return filtered
  }
}

solution([3, 3, 3, 2, 2, 4]);
