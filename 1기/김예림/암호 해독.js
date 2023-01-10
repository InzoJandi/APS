function solution(cipher, code) {
  let arr = [...cipher];
  return arr.filter((_,i) => (i+1)%code === 0).join("")
}