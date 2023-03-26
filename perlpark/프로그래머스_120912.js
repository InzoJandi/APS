/*
 * Programers
 * https://school.programmers.co.kr
 * Problem Number: 120912
 * Level: 0
 * Algorithm: -
 */

/* Pseudocode *
정규표현식과 String.matchAll 메서드를 이용하여 개수를 찾아서 반환
*/

function solution(array) {
  return Array.from(array.join("").matchAll(/7/g)).length;
}