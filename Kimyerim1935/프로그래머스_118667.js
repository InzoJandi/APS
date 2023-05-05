/*
 *  PROGRAMMERS SCHOOL
 *  https://school.programmers.co.kr
 *  Problem Number: 118667
 *  Level: 2
 *  Algorithm: Implementation
 */

function solution(q1, q2) {
    let q1s = q1.reduce((acc, curr) => acc + curr, 0)
    let q2s = q2.reduce((acc, curr) => acc + curr, 0)
    let limit = q1.length * 3
    let dest = parseInt((q1s + q2s) / 2)
    let d1 = 0
    let d2 = 0
    let result = 0
    while (result !== limit && q1s !== dest) {
        if (q1s < q2s) {
            q1.push(q2[d2])
            q1s += q2[d2]
            q2s -= q2[d2++]
        } else if (q1s > q2s) {
            q2.push(q1[d1])
            q2s += q1[d1]
            q1s -= q1[d1++]
        }
        result += 1
    }
    return result === limit ? -1 : result
}