/*
 * Programers
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * Problem Number: 86491
 * Level: 1
 * Algorithm: Brute Force
 */

/*
 * sizes의 길이는 1 이상 10,000 이하입니다.
 * sizes의 원소는 [w, h] 형식입니다.
 * w는 명함의 가로 길이를 나타냅니다.
 * h는 명함의 세로 길이를 나타냅니다.
 * w와 h는 1 이상 1,000 이하인 자연수입니다.
 */

function solution(sizes) {
    const rotated = sizes.map(([w, h]) => (w < h ? [h, w] : [w, h]));

    let maxSize = [0, 0];
    rotated.forEach(([w, h]) => {
        if (w > maxSize[0]) maxSize[0] = w;
        if (h > maxSize[1]) maxSize[1] = h;
    });
    return maxSize[0] * maxSize[1];
}
