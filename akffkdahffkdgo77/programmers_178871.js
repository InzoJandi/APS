/*
 *  PROGRAMMERS SCHOOL
 *  https://school.programmers.co.kr
 *  Problem Number: 178871
 *  Level: 1
 *  Algorithm: Implementation
 */

/* Pseudocode *
    배열 (findIndex, indexOf) 등을 사용하면 시간초과
    hash를 사용해서 풀기
*/

function solution(players, callings) {
    const playerMap = new Map();
    for (let i = 0; i < players.length; i++) {
        playerMap.set(players[i], i);
    }

    for (let i = 0; i < callings.length; i++) {
        const index = playerMap.get(callings[i]);
        const change = players[index - 1];

        playerMap.set(callings[i], index - 1);
        playerMap.set(change, index);

        players[index] = players[index - 1];
        players[index - 1] = callings[i];
    }

    return players;
}
