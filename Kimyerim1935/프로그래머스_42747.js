/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * Problem Number: 42747
 * Level: 코딩테스트 연습
 * Algorithm: 정렬
 */


function solution(citations) {
    citations = citations.sort((a, b) => b - a);
    
    let i = 0;
    
    while (i + 1 <= citations[i]) {
        i++;
    }
    
    return i;
}