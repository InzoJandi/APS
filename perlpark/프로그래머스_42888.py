"""
 * Programers
 * https://school.programmers.co.kr
 * Problem Number: 42888
 * Level: 2
 * Algorithm: String
"""

""" Pseudocode *
주어진 record를 채팅방 메세지로 변환하면서 id와 nickname을 저장,
메세지를 반환하면서 id를 nickname으로 바꿔줌
"""

def solution(record):
    answer = []
    userDic = {}
    
    for rcd in record:
        action, *user = rcd.split()

        if action == 'Enter':
            userDic[user[0]] = user[1]
            answer.append([user[0], '님이 들어왔습니다.'])
        if action == 'Leave':
            answer.append([user[0], '님이 나갔습니다.'])
        if action == 'Change':
            userDic[user[0]] = user[1]

    def convertMsg(rcd):
        id, msg = rcd
        return userDic[id] + msg
    
    return list(map(convertMsg, answer))