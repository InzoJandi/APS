function solution(n) {
    let answer = 0;
    if (Number.isInteger(Math.sqrt(n))) {
        return answer = Math.pow(parseInt(Math.sqrt(n)+1), 2);
    } else return -1
}
