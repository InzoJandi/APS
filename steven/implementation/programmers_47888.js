/*
 * LeetCode
 * https: https://school.programmers.co.kr/learn/courses/30/lessons/42888
 * Problem Number: 42888
 * Level: 1
 * Algorithm: Implementation
 */

/* Pseudocode *
record 배열을 순회하며 users 객체에 유저 아이디와 닉네임 저장
record 배열을 순회하며 messages 배열에 메시지 저장
messages 배열을 순회하며 각 메시지의 uid에 해당하는 닉네임을 적용
 */

function solution(record) {
    // 유저 아이디와 닉네임을 저장할 객체 생성
    const users = {};
    // 채팅방에서 일어난 메시지를 저장할 배열 생성
    const messages = [];
  
    // record 배열을 순회하며 users 객체에 유저 아이디와 닉네임 저장
    for (let element of record) {
      const [_, uid, nickname] = element.split(" ");
      if (nickname) {
        users[uid] = nickname;
      }
    }
  
    // record 배열을 순회하며 messages 배열에 메시지 저장
    for (let element of record) {
      const [action, uid, _] = element.split(" ");
      if (action === "Enter") {
        messages.push({ uid, message: "님이 들어왔습니다." });
      } else if (action === "Leave") {
        messages.push({ uid, message: "님이 나갔습니다." });
      }
    }
  
    // messages 배열을 순회하며 각 메시지의 uid에 해당하는 닉네임을 적용
    return messages.map((message) => {
      return `${users[message.uid]}${message.message}`;
    });
  }
