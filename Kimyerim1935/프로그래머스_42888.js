/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 * Problem Number: 42888
 * Level: 3 
 * Algorithm: 문자열
 */

function solution(record) {
    let answer = [];
    const map = new Map();
    
    for (let i = 0; i < record.length; ++i) {
        const [state, uid, name] = record[i].split(' ');
        
        if (state == 'Leave') {
            answer.push([uid, '님이 나갔습니다.']);
            
           continue;
        } else if (state == 'Enter') {
            answer.push([uid, '님이 들어왔습니다.']);
        }

        map.set(uid, name);
    }
    
    return answer.map(ele => map.get(ele[0]) + ele[1]);
}