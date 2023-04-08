/*
 * Programers
 * https://school.programmers.co.kr
 * Problem Number: 42888
 * Level: 2
 * Algorithm: String
*/

/* Pseudocode *
주어진 record를 채팅방 메세지로 변환하면서 id와 nickname을 저장,
메세지를 반환하면서 id를 nickname으로 바꿔줌
*/

function solution(record) {
    const answer = [];
    const nameMap = new Map();
  
    record.forEach((rcd) => {
      const [action, id, name] = rcd.split(' ');
  
      if (action === 'Enter') {
        nameMap.set(id, name);
        answer.push([id, '님이 들어왔습니다.']);
      }
      if (action === 'Leave') {
        answer.push([id, '님이 나갔습니다.']);
      }
      if (action === 'Change') {
        nameMap.set(id, name);
      }
    });
  
    return answer.map(([id, msg]) => `${nameMap.get(id)}${msg}`);
  }