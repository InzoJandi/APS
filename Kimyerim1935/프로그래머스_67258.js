/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/67258
 * Problem Number: 67258
 * Level: 3 
 * Algorithm: 투 포인터
 */

/*
 * gems 배열이 주어질 때 가장 짧은 구간을 리턴
 */


function solution(gems) {
    const count = new Set(gems).size;
    const gemMap = new Map();
    
    let answer = [1, gems.length];
    gems.forEach((gem, i) => {
        gemMap.delete(gem);
        gemMap.set(gem, i);
        if (gemMap.size === count){
            const cand = [gemMap.values().next().value + 1, i + 1];
            answer = answer[1] - answer[0] > cand[1] - cand[0] ? cand : answer;
        }
    })
    return answer;
}