/*
 *  PROGRAMMERS SCHOOL
 *  https://school.programmers.co.kr
 *  Problem Number: 42888
 *  Level: 2
 *  Algorithm: Implementation
 */

/* Pseudocode *
    1.  uid - 닉네임 map을 생성 (최종 닉네임을 표시하면 되니까 미리 작업)    
    2.  Enter와 Leave 케이스 처리
*/

function solution(record) {
    const nameList = new Map();
    record.forEach((val) => {
        const [_action, uid, nickname] = val.split(' ');
        if (nickname) {
            nameList.set(uid, nickname);
        }
    });

    const chat = [];
    record
        .filter((val) => val.split(' ')[0] !== 'Change')
        .forEach((val) => {
            const [action, uid] = val.split(' ');
            if (action === 'Leave') {
                chat.push(`${nameList.get(uid)}님이 나갔습니다.`);
            } else {
                chat.push(`${nameList.get(uid)}님이 들어왔습니다.`);
            }
        });

    return chat;
}
